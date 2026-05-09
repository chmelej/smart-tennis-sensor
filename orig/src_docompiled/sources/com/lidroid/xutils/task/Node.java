package com.lidroid.xutils.task;

/* JADX INFO: compiled from: PriorityObjectBlockingQueue.java */
/* JADX INFO: loaded from: classes.dex */
class Node<T> {
    Node<T> next;
    private PriorityObject<?> value;
    private boolean valueAsT = false;

    Node(T t) {
        setValue(t);
    }

    public Priority getPriority() {
        return this.value.priority;
    }

    public T getValue() {
        if (this.value == null) {
            return null;
        }
        if (this.valueAsT) {
            return (T) this.value;
        }
        return (T) this.value.obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setValue(T t) {
        if (t == 0) {
            this.value = null;
        } else if (t instanceof PriorityObject) {
            this.value = (PriorityObject) t;
            this.valueAsT = true;
        } else {
            this.value = new PriorityObject<>(Priority.DEFAULT, t);
        }
    }
}
