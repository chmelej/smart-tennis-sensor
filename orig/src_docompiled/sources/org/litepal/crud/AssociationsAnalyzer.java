package org.litepal.crud;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DataSupportException;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
abstract class AssociationsAnalyzer extends DataHandler {
    AssociationsAnalyzer() {
    }

    protected Collection<DataSupport> getReverseAssociatedModels(DataSupport dataSupport, AssociationsInfo associationsInfo) {
        return (Collection) takeGetMethodValueByField(dataSupport, associationsInfo.getAssociateSelfFromOtherModel());
    }

    protected void setReverseAssociatedModels(DataSupport dataSupport, AssociationsInfo associationsInfo, Collection<DataSupport> collection) {
        putSetMethodValueByField(dataSupport, associationsInfo.getAssociateSelfFromOtherModel(), collection);
    }

    protected Collection<DataSupport> checkAssociatedModelCollection(Collection<DataSupport> collection, Field field) {
        Collection<DataSupport> hashSet;
        if (isList(field.getType())) {
            hashSet = new ArrayList<>();
        } else if (isSet(field.getType())) {
            hashSet = new HashSet<>();
        } else {
            throw new DataSupportException(DataSupportException.WRONG_FIELD_TYPE_FOR_ASSOCIATIONS);
        }
        if (collection != null) {
            hashSet.addAll(collection);
        }
        return hashSet;
    }

    protected void buildBidirectionalAssociations(DataSupport dataSupport, DataSupport dataSupport2, AssociationsInfo associationsInfo) {
        putSetMethodValueByField(dataSupport2, associationsInfo.getAssociateSelfFromOtherModel(), dataSupport);
    }

    protected void dealsAssociationsOnTheSideWithoutFK(DataSupport dataSupport, DataSupport dataSupport2) {
        if (dataSupport2 != null) {
            if (dataSupport2.isSaved()) {
                dataSupport.addAssociatedModelWithFK(dataSupport2.getTableName(), dataSupport2.getBaseObjId());
            } else if (dataSupport.isSaved()) {
                dataSupport2.addAssociatedModelWithoutFK(dataSupport.getTableName(), dataSupport.getBaseObjId());
            }
        }
    }

    protected void mightClearFKValue(DataSupport dataSupport, AssociationsInfo associationsInfo) {
        dataSupport.addFKNameToClearSelf(getForeignKeyName(associationsInfo));
    }

    private String getForeignKeyName(AssociationsInfo associationsInfo) {
        return getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName()));
    }
}
