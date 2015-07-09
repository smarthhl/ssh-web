Creditease API
========
# Catalog
## [SDK API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README.md#sdk-api-1)
***
### [App to Server Message](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README.md#app-to-server-message-1)
#### [submitEvent](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README.md#submitevent-1)
#### [locationSave](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README.md#locationsave-1)
#### [devSave](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README.md#devsave-1)
#### [checkAppKey](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README.md#checkappkey-1)


# SDK API 1:
## App to Server Message 1
### submitEvent 1
描述:用户提交事件<br/>

#### API Name
submitEvent

#### API URI
http://${host}/appsdk/app!submitEvent

#### Support Method
Get and Post.

#### Parameters
```table
|| 名称 ||描述
| event_info | 要传递给服务器的事件信息，使用base64进行编码
```

#### Data Format
```json
{
    "app_key": "xxxxxx",
    "imei": "xxxxxx",
    "imsi": "xxxxxx",
    "serial_num": "xxxxxx",
    "simid ": "xxxxxx",
    "mac": "xxxxxx",
    "os": "xxxxxx",
    "os_version": "xxxxxx",
    "app_channel": "xxxxxx",
    "app_version_code": "xxxxxx",
    "app_version_name": "xxxxxx",
    "sdk_version": "xxxxxx",
    "event_list": [
        {
            "user_id": " xxxxxx",
            "event_id": " xxxxxx",
            "activity": " xxxxxx",
            "scan_time": " xxxxxx",
            "param_list": [
                {
                    "param_name": "xxxxxx",
                    "param_val": "xxxxxx"
                },
                ……
            ]
        },
        ……
    ]
}
```

#### Response
Successful:
```json
{
    "api_msg": "上传成功",
    "api_status_cd": "0"
}
```
Fail:
```json
{
    "api_msg": "上传失败",
    "api_status_cd": "1"
}
```

### locationSave 1
描述:提交位置信息

#### API Name
locationSave

#### API URI
http://${host}/appsdk/app!locationSave

#### Support Method
Get and Post.

#### Parameters
```table
|| 名称 ||描述
| locationInfo | 要传递给服务器的位置信息，使用base64进行编码
```

#### Data Format
```json
{
    "app_key": xxxxxx,
    "imei": xxxxxx,
    "imsi": xxxxxx,
    “simid”: xxxxxx,
    "serial_num": xxxxxx,
    "mac": xxxxxx,
    “dev_location”: ##多次扫描,
    表名：dev_location[
        {
            "conn_type": xxxxxx,
            “mobile_carrier”: xxxxxx,
            "wifi_ssid": xxxxxx,
            "wifi_name": xxxxxx,
            "wifi_level": xxxxxx,
            "base_station": xxxxxx,
            "ip": xxxxxx,
            "loc_longitude": xxxxxx,
            "loc_latitude": xxxxxx,
            “addr”: xxxxxx,
            “radius”: xxxxxx,
            “addr_sep”: xxxxxx,
            "scan_time": xxxxxx,
            “wifi_list”: ##多值集合,
            表名：dev_wifi_list[
                {
                    "wifi_ssid": xxxxxx,
                    "wifi_name": xxxxxx,
                    "wifi_level": xxxxxx,
                    "capability": xxxxxx
                },
                {
                    "wifi_ssid": xxxxxx,
                    "wifi_name": xxxxxx,
                    "wifi_level": xxxxxx,
                    "capability": xxxxxx
                },
                ……
            ]
        },
        ……
    ]
}
```

#### Response
Successful:
```json
{
    "api_msg": "上传成功",
    "api_status_cd": "0"
}
```
Fail:
```json
{
    "api_msg": "上传失败",
    "api_status_cd": "1"
}
```

### devSave 1
描述：用户设备信息

#### API Name
devSave

#### API URI
http://${host}/appsdk/app!devSave

#### Support Method
Get and Post.

#### Parameters
```table
|| 名称 ||描述
| devInfo | 要传递给服务器的设备信息，使用base64进行编码
```

#### Data Format
```json
{
    ##表名：dev"app_key": xxxxxx,
    "imei": xxxxxx,
    "imsi": xxxxxx,
    “simid”: xxxxxx,
    "serial_num": xxxxxx,
    "idfa": xxxxxx,
    "idfv": xxxxxx,
    "openudid": xxxxxx,
    "secureudid": xxxxxx,
    "mac": xxxxxx,
    "manufacturer": xxxxxx,
    "mobile_model": xxxxxx,
    "mem_size": xxxxxx,
    "sdcard_size": xxxxxx,
    "screen_width": xxxxxx,
    "screen_height": xxxxxx,
    "screen_density": xxxxxx,
    "cpu": xxxxxx,
    "os": xxxxxx,
    "os_version": xxxxxx,
    “app_channel”: xxxxxx,
    “app_channel_sub”: xxxxxx,
    “app_version_code”: xxxxxx,
    “app_version_name”: xxxxxx,
    “app_inst_time”: xxxxxx,
    “sdk_version”: xxxxxx,
    "scan_time": xxxxxx,
    “installed_app”: ##多值集合,
    表名：dev_inst_app_list[
        {
            "app_name": xxxxxx,
            "app_pkg_name": xxxxxx,
            "version_code": xxxxxx,
            "version_name": xxxxxx,
            "app_inst_time": xxxxxx,
            “latest_usage_time”: xxxxxx,
            “is_sys_app”: xxxxxx
        },
        ……
    ],
    “contact_list”: ##多值集合,
    表名：dev_contact_list[
        {
            "sim_id": xxxxxx,
            "first_name": xxxxxx,
            "last_name": xxxxxx,
            "phone_type": xxxxxx,
            "phone_num": xxxxxx
        },
        ……
    ],
    “dev_location”: ##多次扫描,
    表名：dev_location[
        {
            "conn_type": xxxxxx,
            “mobile_carrier”: xxxxxx,
            "wifi_ssid": xxxxxx,
            "wifi_name": xxxxxx,
            "wifi_level": xxxxxx,
            "base_station": xxxxxx,
            "ip": xxxxxx,
            "loc_longitude": xxxxxx,
            "loc_latitude": xxxxxx,
            “addr”: xxxxxx,
            “radius”: xxxxxx,
            "scan_time": xxxxxx,
            “wifi_list”: ##多值集合,
            表名：dev_wifi_list[
                {
                    "wifi_ssid": xxxxxx,
                    "wifi_name": xxxxxx,
                    "wifi_level": xxxxxx,
                    "capability": xxxxxx
                },
                {
                    "wifi_ssid": xxxxxx,
                    "wifi_name": xxxxxx,
                    "wifi_level": xxxxxx,
                    "capability": xxxxxx
                },
                ……
            ]
        },
        ……
    ],
    “act_app”: ##多次扫描,
    表名：dev_act_app_list[
        {
            "scan_time": xxxxxx,
            “act_app_list”: ##多值集合[
                {
                    "app_name": xxxxxx,
                    "app_pkg_name": xxxxxx,
                    "app_enter_from": xxxxxx,
                    “latest_usage_time”: xxxxxx
                },
                ……
            ]
        },
        ……
    ],
    “app_action_list”: ##多次扫描,
    表名：app_stat[
        {
            "open_time": xxxxxx,
            "close_time": xxxxxx,
            "scan_time": xxxxxx
        },
        ……
    ],
    “page_action_list”: ##多次扫描,
    表名：app_page_stat[
        {
            "page_name": xxxxxx,
            "pre_page_name": xxxxxx,
            "open_time": xxxxxx,
            "close_time": xxxxxx,
            "scan_time": xxxxxx
        },
        ……
    ],
    “exception_list”: ##多次扫描,
    表名：app_exception[
        {
            “err_name”: xxxxxx,
            “stack_trace”: xxxxxx,
            “occur_time”: xxxxxx,
            "scan_time": xxxxxx
        },
        ……
    ]
}
```

#### Response
Successful:
```json
{
    "api_msg": "上传成功",
    "api_status_cd": "0"
}
```
Fail:
```json
{
    "api_msg": "上传失败",
    "api_status_cd": "1"
}
```

### checkAppKey 1
描述：检查app key

#### API Name
checkAppKey

#### API URI
http://${host}/appsdk/app!checkAppKey

#### Support Method
Get and Post.

#### Parameters
```table
|| 名称 ||描述
| app_key | app key
| app_type_id | app类型id
| app_pkg_name | app包名
```

#### Response
Successful:
```json
{
    "key_status": "0",
    "status_message": "APP KEY有效"
}
```
Fail:
```json
{
    "key_status": "1",
    "status_message": "APP KEY已过期"
}
```

```json
{
    "key_status": "2",
    "status_message": "请先申请APP KEY"
}
```

```json
{
    "key_status": "3",
    "status_message": "请填写正确的APP KEY"
}
```


