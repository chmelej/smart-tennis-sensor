package com.umeng.message;

/* JADX INFO: loaded from: classes.dex */
public class MsgConstant {
    public static final int ACTION_TYPE_MSG_ARRIVAL = 0;
    public static final int ACTION_TYPE_MSG_CLICK = 1;
    public static final int ACTION_TYPE_MSG_DISMISS = 2;
    public static final int ACTION_TYPE_MSG_DISPLAY = 3;
    public static String ALIAS_ENDPOINT = null;
    public static String ALIAS_EXCLUSIVE_ENDPOINT = null;
    public static final int APP_LAUNCH_BY_MESSAGE = 1;
    public static final int APP_LAUNCH_BY_UNSET = 0;
    public static final int APP_LAUNCH_BY_USER = 2;
    public static final int CACHE_LOG_COUNT_MAX = 20;
    public static final String CACHE_LOG_FILE_EXT = ".log";
    public static final String CACHE_LOG_FILE_PREFIX = "umeng_message_log_cache_";
    public static final String DEFAULT_INTENT_SERVICE_CLASS_NAME;
    public static String DELETE_ALIAS_ENDPOINT = null;
    public static final int FAILALIAS = 0;
    public static final int FAILEXCLUSIVEALIAS = 1;
    public static final String KEY_ACTION_TYPE = "action_type";
    public static final String KEY_ALIAS = "alias";
    public static final String KEY_APP_LAUNCH_LOG_SEND_POLICY = "KEY_APP_LAUNCH_LOG_SEND_POLICY";
    public static final String KEY_CACHE_FILE_TRANSFER_TO_SQL = "KEY_CACHE_FILE_TRANSFER_TO_SQL";
    public static final String KEY_DEVICETOKEN = "KEY_DEVICETOKEN";
    public static final String KEY_DEVICE_TOKEN = "device_token";
    public static final String KEY_ENEABLED = "KEY_ENEABLED";
    public static final String KEY_HEADER = "header";
    public static final String KEY_LAST_ALIAS = "last_alias";
    public static final String KEY_LAST_MSG_ID = "last_msg_id";
    public static final String KEY_LAUNCH_LOG_SENT_MARK = "KEY_LAUNCH_LOG_SENT_MARK";
    public static final String KEY_MERGE_NOTIFICATION = "KEY_MERGE_NOTIFICATION";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_MSG_RESOURCE_DOWNLOAD_PREFIX = "KEY_MSG_RESOURCE_DOWNLOAD_PREFIX";
    public static final String KEY_MUTE_DURATION = "mute_duration";
    public static final String KEY_NO_DISTURB_END_HOUR = "KEY_NO_DISTURB_END_HOUR";
    public static final String KEY_NO_DISTURB_END_MINUTE = "KEY_NO_DISTURB_END_MINUTE";
    public static final String KEY_NO_DISTURB_START_HOUR = "KEY_NO_DISTURB_START_HOUR";
    public static final String KEY_NO_DISTURB_START_MINUTE = "KEY_NO_DISTURB_START_MINUTE";
    public static final String KEY_PUSH_INTENT_SERVICE_CLASSNAME = "KEY_PUSH_INTENT_SERVICE_CLASSNAME";
    public static final String KEY_REGISTERED_TO_UMENG = "KEY_REGISTERED_TO_UMENG_";
    public static final String KEY_REGISTRATION_ID = "registration_id";
    public static final String KEY_SERIA_NO = "serial_no";
    public static final String KEY_SET_LOCALNOTIFICATION_INTERVAL_LIMIT = "KEY_SET_LOCALNOTIFICATION_INTERVAL_LIMIT";
    public static final String KEY_SET_NOTIFICATION_ON_FOREGROUND = "KEY_SET_NOTIFICATION_ON_FOREGROUND";
    public static final String KEY_SET_NOTIFICATION_PLAY_LIGHTS = "KEY_SET_NOTIFICATION_PLAY_LIGHTS";
    public static final String KEY_SET_NOTIFICATION_PLAY_SOUND = "KEY_SET_NOTIFICATION_PLAY_SOUND";
    public static final String KEY_SET_NOTIFICATION_PLAY_VIBRATE = "KEY_SET_NOTIFICATION_PLAY_VIBRATE";
    public static final String KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE = "KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE";
    public static final String KEY_SET_RESOURCE_PACKAGENAME = "KEY_SET_RESOURCE_PACKAGENAME";
    public static final String KEY_TAGS = "tags";
    public static final String KEY_TAG_SEND_POLICY = "KEY_TAG_SEND_POLICY";
    public static final String KEY_TS = "ts";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UMENG_MESSAGE_APP_CHANNEL = "KEY_UMENG_MESSAGE_APP_CHANNEL";
    public static final String KEY_UMENG_MESSAGE_APP_KEY = "KEY_UMENG_MESSAGE_APP_KEY";
    public static final String KEY_UMENG_MESSAGE_APP_SECRET = "KEY_UMENG_MESSAGE_APP_SECRET";
    public static final String KEY_UTDID = "utdid";
    public static String LAUNCH_ENDPOINT = null;
    public static String LOG_ENDPOINT = null;
    public static final String MESSAGE_AUTOUPDATE_HANDLER_ACTION = "com.umeng.message.autoupdate.handler.action";
    public static final String MESSAGE_MESSAGE_HANDLER_ACTION = "com.umeng.message.message.handler.action";
    public static final String MESSAGE_NOTIFY_ARRIVAL = "7";
    public static final String MESSAGE_NOTIFY_CLICK = "8";
    public static final String MESSAGE_NOTIFY_DISMISS = "9";
    public static final String MESSAGE_NOTIFY_FOR_AGOO_ACTION = "message_notify_for_agoo_action";
    public static final String MESSAGE_REGISTER_CALLBACK_ACTION = "com.umeng.messge.registercallback.action";
    public static final String MESSAGE_SYSTEM_SOURCE_XIAOMI = "xiaomi";
    public static final String MESSAGE_UNREGISTER_CALLBACK_ACTION = "com.umeng.message.unregistercallback.action";
    public static final int NOTIFICATION_MERGE_ID = 20100401;
    public static final int NOTIFICATION_PLAY_SDK_DISABLE = 2;
    public static final int NOTIFICATION_PLAY_SDK_ENABLE = 1;
    public static final int NOTIFICATION_PLAY_SERVER = 0;
    public static final String PERMISSION_ACCESS_NETWORK_STATE = "android.permission.ACCESS_NETWORK_STATE";
    public static final String PERMISSION_ACCESS_WIFI_STATE = "android.permission.ACCESS_WIFI_STATE";
    public static final String PERMISSION_CHANGE_NETWORK_STATE = "android.permission.CHANGE_NETWORK_STATE";
    public static final String PERMISSION_CHANGE_WIFI_STATE = "android.permission.CHANGE_WIFI_STATE";
    public static final String PERMISSION_GET_TASKS = "android.permission.GET_TASKS";
    public static final String PERMISSION_INTERNET = "android.permission.INTERNET";
    public static final String PERMISSION_READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String PERMISSION_RECEIVE_BOOT_COMPLETED = "android.permission.RECEIVE_BOOT_COMPLETED";
    public static final String PERMISSION_WAKE_LOCK = "android.permission.WAKE_LOCK";
    public static final String PERMISSION_WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String PERMISSION_WRITE_SETTINGS = "android.permission.WRITE_SETTINGS";
    public static final String PREF_XIAOMI = "pref_xiaomi";
    public static final String PROTOCOL_VERSION = "1.0";
    public static final String PUSH_SHARED_PREFERENCES_FILE_NAME = "umeng_message_state";
    public static String REGISTER_ENDPOINT = null;
    public static final String SDK_VERSION = "2.7.0";
    public static final int SUCCESS = 2;
    public static final int SUCCESSEXCLUSIVEALIAS = 3;
    public static String TAG_ENDPOINT = null;
    public static final String XIAOMI_REGID = "xiaomi_regid";

    /* JADX INFO: renamed from: a */
    static long f9162a = 300000;

    /* JADX INFO: renamed from: b */
    private static String f9163b = "msg.umengcloud.com";

    /* JADX INFO: renamed from: c */
    private static String f9164c = "msg.umengcloud.com/v2";

    /* JADX INFO: renamed from: d */
    private static String f9165d = "http";

    static {
        String str = f9165d + "://" + f9164c + "/";
        LOG_ENDPOINT = str + "push_logs";
        REGISTER_ENDPOINT = str + "register";
        ALIAS_ENDPOINT = str + KEY_ALIAS;
        ALIAS_EXCLUSIVE_ENDPOINT = str + "alias/set";
        DELETE_ALIAS_ENDPOINT = ALIAS_ENDPOINT + "/delete";
        LAUNCH_ENDPOINT = str + "launch";
        TAG_ENDPOINT = str + "tag";
        DEFAULT_INTENT_SERVICE_CLASS_NAME = UmengIntentService.class.getName();
    }
}
