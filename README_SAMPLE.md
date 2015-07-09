pier_api
========
# Catalog
#### [Overview](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#overview-1)
***
#### [Environment And Deployment](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#environment-and-deployment-1)
***
##### 	[Environment](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#environment-1)
##### 	[Deployment](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#%deployment-1)
#### [Response Data](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#response-data-1)
***
#### [API Introduce](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#api-introduce-1)
***
##### 	[COMMON API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#common-api-1)
***
###### 	[Query API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#query-api-1)
###### 	[APNS API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#apns-api-1)
###### 	[BANKVERIFICATION API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#bankverification-api-1)
###### 	[REFUND API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#refund-api-1)
###### 	[WAITINGLIST API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#waitinglist-api-1)
###### 	[FREEZE API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#freeze-api-1)
***
##### 	[USER API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#user-api-1)
***
###### 	[V2 MANAGE API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#v2-manage-api-1)
###### 	[V2 STATEMENT API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#v2-statement-api-1)
###### 	[V2 INBOX API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#v2-inbox-api-1)
###### 	[V2 USER SERVICE API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#v2-user-service-api-1)
###### 	[V2 MERCHANT USER SDK (IOS)](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#v2-merchant-user-sdk-ios-1)
###### 	[V2 CONTANCTS API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#v2-contancts-api-1)
###### 	[USERSUPPORT API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#usersupport-api-1)
***
##### 	[MERCHANT API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-api-1)
***
###### 	[MERCHANT QUERY API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-query-api-1)
###### 	[MERCHANT REGISTER API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-register-api-1)
###### 	[MERCHANT MANGE API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-mange-api-1)
###### 	[Merchant Transaction API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-transaction-api-1)
###### 	[Merchant Dashboard API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-dashboard-api-1)
###### 	[MERCHANT TRANSFER API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-transfer-api-1)
######		[MERCHANT FAKE SERVICE API](http://10.36.0.250/PlatformTeam/iCreditease-Web/blob/master/README_SAMPLE.md#merchant-fake-service-api-1)


# Overview 1:
PIER API 主要包括三部分：<br/>
common api<br/>
公用的api接口<br/>
${host}/common_api/v*/**<br/>

user api<br/>
用户相关的api接口<br/>
${host}/user_api/v*/**<br/>

merchant api<br/>
商家相关的api接口<br/>
${host}/merchant_api/v*/**<br/>


# Environment And Deployment 1

## Environment 1：
JDK 1.7+ <br/>
Maven 3.0+ <br/>

## Deployment 1：
1.在pier_api目录下运行"mvn clean install -P US"； <br/>
  US针对美国的数据库环境配置config-US.properties,CN针对中国的数据库环境配置config-CN.properties<br/>
2.拷贝需要发布的模块(例如:api-merchant), pier_api/api-merchant/target/merchant_api.war 到tomcat安装目录下的webapps目录下面<br/>
3.在浏览器里输入地址  ${host:port}/merchant_api/v1/index.html 测试部署是否成功；<br/>


# Response Data 1
每次调用一个api，返回的数据由四部分构成:<br/>
1. http_code:返回给client的HTTP STATUS LINE CODE, 例如服务器发生错误返回INTERNAL_SERVER_ERROR(500), 提交的参数错误时返回BAD_REQUEST(400),提示数据输入错误; <br/>
具体定义查看：<a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10">HTTP/1.1 documentation</a><br/>
前端可以根据http_code来调用相应的error() or success()函数来处理对应的返回数据；<br/>
2. code: 自定义的状态码，例如1001 TOKEN过期等；<br/>
3. message: 对自定义状态码的描述信息； <br/>
4. result: 返回数据时，返回的数据信息在result字段里； <br/>


# API Introduce 1

# COMMON API 1

## Query API 1

### apiName: get_address_types
description: get_address_types；<br/>

apiUrl: ${host}/common_api/v1/query/get_address_types<br/>
method: GET<br/>

request: ==><br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "sort": "1",
                "desc": "Home",
                "address_type_code": "1",
                "active": "1"
            },
            {
                "sort": "2",
                "desc": "Work",
                "address_type_code": "2",
                "active": "1"
            },
            {
                "sort": "3",
                "desc": "Other",
                "address_type_code": "3",
                "active": "1"
            }
        ]
    }
}
```

若没有数据，则返回<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": null
}
```

### apiName: validate_address
description: get_address_types；<br/>

apiUrl: ${host}/common_api/v1/query/validate_address<br/>
method: POST<br/>

request: ==><br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

```json
{
    "address": "401 College Street Richmond, Virginia 23298 "
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "city": "Richmond",
        "countryCode": "US",
        "postalCode": "23298",
        "state": "VA",
        "street": "401 College St"
    }
}
```

failure message<br/>
```json
{
    "code": "400",
    "message": "Invalidate Address: 401 College Street Richmond, Virginia 2328 ",
    "result": ""
}
```


### apiName: get_countries
description: 查询国家代码；<br/>

apiUrl: ${host}/common_api/v1/query/get_countries<br/>
method: GET<br/>

request: ==><br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "name": "UNITED STATES",
                "phone_prefix": "1",
                "code": "US",
                "phone_size": "10"
            },
            {
                "name": "CHINA",
                "phone_prefix": "86",
                "code": "CN",
                "phone_size": "11"
            }
        ]
    }
}
```

若没有数据，则返回<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": null
}
```

### apiName: get_state_and_province
description: 获取指定国家的省份信息。<br/>
apiUrl: ${host}/common_api/v1/query/get_state_and_province<br/>
method: GET<br/>

request: ==><br/>
country_code：US<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "state_code": "WY",
                "description": "Wyoming"
            },
            {
                "state_code": "OK",
                "description": "Oklahoma"
            },
            {
                "state_code": "OH",
                "description": "Ohio"
            },
            {
                "state_code": "NY",
                "description": "New York"
            },
            {
                "state_code": "NV",
                "description": "Nevada"
            },
            {
                "state_code": "NM",
                "description": "New Mexico"
            },
            {
                "state_code": "NJ",
                "description": "New Jersey"
            },
            {
                "state_code": "NH",
                "description": "New Hampshire"
            },
            {
                "state_code": "NE",
                "description": "Nebraska"
            },
            {
                "state_code": "ND",
                "description": "North Dakota"
            },
            {
                "state_code": "NC",
                "description": "North Carolina"
            },
            {
                "state_code": "OR",
                "description": "Oregon"
            },
            {
                "state_code": "PA",
                "description": "Pennsylvania"
            },
            {
                "state_code": "RI",
                "description": "Rhode Island"
            },
            {
                "state_code": "WV",
                "description": "West Virginia"
            },
            {
                "state_code": "WI",
                "description": "Wisconsin"
            },
            {
                "state_code": "WA",
                "description": "Washington"
            },
            {
                "state_code": "VT",
                "description": "Vermont"
            },
            {
                "state_code": "VA",
                "description": "Virginia"
            },
            {
                "state_code": "UT",
                "description": "Utah"
            },
            {
                "state_code": "TX",
                "description": "Texas"
            },
            {
                "state_code": "TN",
                "description": "Tennessee"
            },
            {
                "state_code": "SD",
                "description": "South Dakota"
            },
            {
                "state_code": "SC",
                "description": "South Carolina"
            },
            {
                "state_code": "MT",
                "description": "Montana"
            },
            {
                "state_code": "MS",
                "description": "Mississippi"
            },
            {
                "state_code": "MO",
                "description": "Missouri"
            },
            {
                "state_code": "GA",
                "description": "Georgia"
            },
            {
                "state_code": "FL",
                "description": "Florida"
            },
            {
                "state_code": "DE",
                "description": "Delaware"
            },
            {
                "state_code": "DC",
                "description": "District of Columbia"
            },
            {
                "state_code": "CT",
                "description": "Connecticut"
            },
            {
                "state_code": "CO",
                "description": "Colorado"
            },
            {
                "state_code": "CA",
                "description": "California"
            },
            {
                "state_code": "AZ",
                "description": "Arizona"
            },
            {
                "state_code": "AR",
                "description": "Arkansas"
            },
            {
                "state_code": "AL",
                "description": "Alabama"
            },
            {
                "state_code": "HI",
                "description": "Hawaii"
            },
            {
                "state_code": "IA",
                "description": "Iowa"
            },
            {
                "state_code": "ID",
                "description": "Idaho"
            },
            {
                "state_code": "MN",
                "description": "Minnesota"
            },
            {
                "state_code": "MI",
                "description": "Michigan"
            },
            {
                "state_code": "ME",
                "description": "Maine"
            },
            {
                "state_code": "MD",
                "description": "Maryland"
            },
            {
                "state_code": "MA",
                "description": "Massachusetts"
            },
            {
                "state_code": "LA",
                "description": "Louisiana"
            },
            {
                "state_code": "KY",
                "description": "Kentucky"
            },
            {
                "state_code": "KS",
                "description": "Kansas"
            },
            {
                "state_code": "IN",
                "description": "Indiana"
            },
            {
                "state_code": "IL",
                "description": "Illinois"
            },
            {
                "state_code": "AK",
                "description": "Alaska"
            }
        ]
    }
}
```

failure message:<br/>
```json
{
    "code": "400",
    "message": "parameter country_code is missing.",
    "result": null
}
```

### apiName: get_bank_info
description: 获取银行相关信息。<br/>
apiUrl: ${host}/common_api/v1/query/get_bank_info<br/>
method: GET<br/>

request: ==><br/>
routing_no：11302603<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "BI9000000003",
                "phonenumber": "978-686-9100",
                "routing_no": "11302603",
                "bank_name": "Northmark Bank",
                "address": "89 TURNPIKE ST",
                "state": "MA",
                "postcode": "01845",
                "city": "NORTH ANDOVER",
                image_url:"http://photo.pierup.com.s3.amazonaws.com/banklogos/BI9000000003.png"
            }
        ]
    }
}
```

failure message:<br/>
```json
{
    "code": "400",
    "message": "parameter routing_no is missing.",
    "result": null
}
```

### apiName: get_bank_account_types
description: 获取银行帐号类型。<br/>
apiUrl: ${host}/common_api/v1/query/get_bank_account_types<br/>
method: GET<br/>

request: ==><br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "1",
                "description": "Checking"
            },
            {
                "id": "2",
                "description": "Saving"
            },
            {
                "id": "3",
                "description": "Money Market"
            }
        ]
    }
}
```

若没有数据，则返回<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": null
}
```

## APNS API 1
### apiName: sms_text
API: [host]/common_api/v1/util/sms_text

Method: GET

INPUT: country_code，phone，content

OUTPUT: code, message

example:
[host]/user_api/v1/util/sms_text?country_code=CN&phone=18671531067&content=hello


```json
{
"code":"200",
"message":"SMS sent to 18671531067",
"result":""
}

```

### apiName: sendTemplateMessage
description: 通过apns发送指定template消息。<br/>
apiUrl: ${host}/common_api/v1/apns/sendTemplateMessage/{templateId}<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
templateId:1<br/>

说明：以下为json参数<br/>
```json
{
    "fromUser": "AAA000000001",
    "toUser": "UR0000000001",
    "fromUser_Session_Token": "c7877042-899d-11e4-aab0-243ecc44f0e8",
    "fromUser_Device_Token": ""[可空，只有当fromUser为商家时]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName: sendCustomMessage
description: 通过apns发送用户自定义消息。<br/>
apiUrl: ${host}/common_api/v1/apns/sendCustomMessage<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "fromUser": "UR0000000001",
    "toUser": "UR0000000001",
    "fromUser_Session_Token": "97e0ed27-89c4-11e4-a7db-112eb400e064",
    "fromUser_Device_Token": "c496225b 8affec8c dfeba326 2131ff2d 14a4a142 0531aa7e 2bb56e79 2b96cb9f",[可空，只有当fromUser为商家时]
    "messageSubject": "Test",
    "messageAPNS": "Test message",
    "messageAbstract": "",[可空，为空时默认为messageAPNS]
    "messageDetail": ""[可空，为空是默认messageAbstract]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName: sendTemplateMessageMass
description: 通过apns群发送指定template消息。<br/>
apiUrl: ${host}/common_api/v1/apns/sendTemplateMessageMass/{templateId}<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
templateId:2<br/>

说明：以下为json参数<br/>
```json
{
    "fromUser": "AAA000000001",[必须为商家]
    "fromUser_Session_Token": "77d14af1-89ac-11e4-aab0-243ecc44f0e8",
    "limit": "100"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName: sendCustomMessageMass
description: 通过apns群发送指定用户自定义消息。<br/>
apiUrl: ${host}/common_api/v1/apns/sendCustomMessageMass<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "fromUser": "AAA000000001",
    "fromUser_Session_Token": "77d14af1-89ac-11e4-aab0-243ecc44f0e8",
    "messageSubject": "Message Test",
    "messageDetail": "",[可空，为空是默认messageAbstract]
    "messageAbstract": "",[可空，为空时默认为messageAPNS]
    "messageAPNS": "Sending message with mass by user customing.",
    "limit": "100"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

## BANKVERIFICATION API 1
### apiName: set_primary_bank_account
description:  设置将银行账户设置为主账户。<br/>
apiUrl: ${host}/common_api/v1/bkcheck/set_primary_bank_account<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "merchant_user_id": "UR0000001011",
    "bank_account_id": "BK0000001023",
    "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e",
    "device_token": "8ceef730 41341f62 01cfd113 650294bb 94d0fc8c 3d8adb97 b9195cac 7472293d"[如果为商家或者platform为WEB，则为空]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName: verify
description:  银行帐号验证第一步，向用户指定帐号转账两笔钱<br/>
apiUrl: ${host}/common_api/v1/bkcheck/verify<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "merchant_user_id": "UR0000001011",
    "bank_account_id": "BK0000001023",
    "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e",
    "device_token": "8ceef730 41341f62 01cfd113 650294bb 94d0fc8c 3d8adb97 b9195cac 7472293d"[如果为商家或者platform为WEB，则为空]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName: verify2
description:  银行帐号验证第二步，用户输入verify过程转账的两笔金额与pier中的account进行匹配<br/>
apiUrl: ${host}/common_api/v1/bkcheck/verify2<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "merchant_user_id": "UR0000001011",
    "bank_account_id": "BK0000001023",
    "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e",
    "device_token": "8ceef730 41341f62 01cfd113 650294bb 94d0fc8c 3d8adb97 b9195cac 7472293d",[如果为商家或者platform为WEB，则为空]
    "amount1": "0.18",
    "amount2": "0.07"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "98469252-8f31-11e4-aad2-0ea81fa3d43c"
    }
}
```

fail message:<br/>
```json
{
    "code": "1104",
    "message": "[USER] Verification to bank account is expired",
    "result": {
        "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e"
    }
}
```

### apiName: verify_instant
description: bank account verify instantly<br/>
apiUrl: ${host}/common_api/v1/bkcheck/verify_instant<br/> 
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
"bank_account_id":"BK0000001199",
"session_token":"52263373-949d-11e4-aad2-0ea81fa3d43c",
"username":"20150106.bank2",
"password":"bank2"
}
```

response: <==<br/>
success message:<br/>
```json
{
"code":"200",
"message":"OK",
"result":{"items":[{"routing_no":"999999989","account_number":"503-1123000","user_merchant_id":"MC0000000134"}],
"session_token":"52263373-949d-11e4-aad2-0ea81fa3d43c"}
}
```



### apiName: link_account
description: link_account instantly<br/>
apiUrl: ${host}/common_api/v1/bkcheck/link_account<br/> 
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
"user_id":"UR0000000010",
"username":"20150106.bank2",
"password":"bank2",
"routingNumber":"999999989",
"session_token":"XXXXXXXXXXXXXXX",
"device_token":"YYYYYYYYYYYYYY"
}
```

response: <==<br/>
success message:<br/>
```json
{"code":"200","message":"OK","result":{}}
```




### apiName: del_bank_account
description:  删除银行帐号。<br/>
apiUrl: ${host}/common_api/v1/bkcheck/del_bank_account<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "merchant_user_id": "UR0000001011",
    "bank_account_id": "BK0000001023",
    "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e",
    "device_token": "8ceef730 41341f62 01cfd113 650294bb 94d0fc8c 3d8adb97 b9195cac 7472293d"[如果为商家或者platform为WEB，则为空]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "cde121da-8b4f-11e4-bf80-5f7f626dfa9e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

## REFUND API 1
### apiName: refund_in_full
description:  全额退款。<br/>
apiUrl: ${host}/common_api/v1/refund/refund_in_full<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "rep_id": "pier.com",[客服id,此時role為0，表示客服执行的退款]
    "session_token": "20add3e2-a929-11e4-8564-77a7e16f885e",
    "transaction_id":"MT0000000030",
    "role":"0",
    "merchant_id":"MC0000000134"[商家id，此时role为1，表示商家执行的退款]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

```json
{
    "code": "500",
    "message": "unknown role for this request,reject.",
    "result": null
}
```

### apiName: refund_in_portion
description:  部分退款。<br/>
apiUrl: ${host}/common_api/v1/refund/refund_in_portion<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "rep_id": "pier.com",[客服id,此時role為0，表示客服执行的退款]
    "session_token": "20add3e2-a929-11e4-8564-77a7e16f885e",
    "transaction_id":"MT0000000030",
    "role":"0",
    "percent":"50",[退款百分值]
    "merchant_id":"MC0000000134"[商家id，此时role为1，表示商家执行的退款]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

```json
{
    "code": "500",
    "message": "unknown role for this request,reject.",
    "result": null
}
```

## WAITINGLIST API 1

### apiName: add_waiting_list
description:  向waiting list中添加数据。<br/>
apiUrl: ${host}/common_api/v1/waitinglist/add_waiting_list<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "first_name": "pier",
    "last_name": "pier",
    "email": "test@pier.com",
    "phone": "123456789",
    "description": "test",
    "type": "3"[1表示CONSUMER 默认值,2表示INVESTOR,3表示MERCHANT,4.表示OTHERS]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```

### apiName: add_advance
description:  添加用户预约信息。<br/>
apiUrl: ${host}/common_api/v1/waitinglist/add_advance<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "country_code": "US",
    "phone": "123456789"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```

### apiName: get_advance_order
description:  获取预约用户的前后等待队列情况。<br/>
apiUrl: ${host}/common_api/v1/waitinglist/get_advance_order<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "country_code": "US",
    "phone": "123456789"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "after": "1",[用户后面等待用户数]
        "before": "1"[用户前面等待用户数]
    }
}
```

## FREEZE API 1
### apiName: freeze
description:  冻结用户或者商家。<br/>
apiUrl: ${host}/common_api/v1/freeze/freeze<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "merchant_user_id": "UR0000000002",
    "rep_id": "pier.com",[客服id]
    "session_token": "20add3e2-a929-11e4-8564-77a7e16f885e"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "20add3e2-a929-11e4-8564-77a7e16f885e"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

```json
{
    "code": "500",
    "message": "Server Error.",
    "result": null
}
```

### apiName: unfreeze
description:  解冻结用户或者商家。<br/>
apiUrl: ${host}/common_api/v1/freeze/freeze<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


说明：以下为json参数<br/>
```json
{
    "merchant_user_id": "UR0000000002",
    "rep_id": "pier.com",[客服id]
    "session_token": "20add3e2-a929-11e4-8564-77a7e16f885e"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "20add3e2-a929-11e4-8564-77a7e16f885e"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

```json
{
    "code": "500",
    "message": "Server Error.",
    "result": null
}
```

# USER API 1
## V2 MANAGE API 1
### apiName: get_pier_accounts
description: 获取用户所有帐号。<br/>
apiUrl: ${host}/user_api/v2/manage/get_pier_accounts<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "session_token": "26b2e003-7ab7-11e4-a108-b3b264dd2935",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "new_session_token": "3e4eae2b-94bc-11e4-aad2-0ea81fa3d43c",
        "items": [
            {
                "balance": "3123.03",
                "next_statement_date": "1422201600000",
                "credit_limit": "5000.00",
                "min_payment": "30.46",
                "alias": "",
                "created_on": "1416891494000",
                "status_bit": "1",
                "due_date": "1421683200000",
                "user_id": "UR0000000001",
                "interest_rate": "",
                "available_credit": "1876.97",
                "currency": "USD"
            }
        ]
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

## V2 STATEMENT API 1
### apiName: payment
description: 用户还款或者充值。<br/>
apiUrl: ${host}/user_api/v2/statement/payment<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求数据<br/>
```json
{
    "user_id": "UR0000000002",
    "amount": "100",
    "notes": "还款",
    "account_id": "BK0000009951",
    "currency": "USD",
    "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
    "device_token": "c496225b 8affec8c dfeba326 2131ff2d 14a4a142 0531aa7e 2bb56e79 2b96cb9f",
    "payment_date": "2015-02-05"[自动扣款日]
}
```

response: <==<br/>
success message:<br/>
未设定自动还款<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "amount": "100.00",
        "bank_name": "Citibank Fsb",
        "account_number": "400**********54X",
        "account_id": "BK0000009951",
        "status": "pending",
        "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/BI9000001465.png",
        "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e"
    }
}
```

设定自动还款<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "amount": "100.00",
        "bank_name": "Citibank Fsb",
        "account_number": "400**********54X",
        "account_id": "BK0000009951",
        "status": "scheduled",
        "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/BI9000001465.png",
        "session_token": "690cc288-ace7-11e4-8564-77a7e16f885e",
        "schedule_date": "1423152000000"
    }
}
```

failure message:<br/>
session_token失效<br/>
http_code: 401<br/>
```json
     {
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "account_id": "BK0000000016",
         "session_token": null
     }
}
```

### apiName: get_payment_info
description: 获取用户还款或者充值。<br/>
apiUrl: ${host}/user_api/v2/statement/get_payment_info<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求数据<br/>
```json
{
    "user_id": "UR0000000001",
    "currency": "USD",
    "session_token": "e2e234f7-94aa-11e4-aad2-0ea81fa3d43c",
    "device_token": "3e33a657 bfde3715 57ea3c34 1abc1b99 cb58512d cf00f059 e9228cda 5276256f"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "statement": [
            {
                "min_payment": "30.46",
                "statement_date": "1419523200000",
                "statement_balance": "3046.12",
                "current_balance": "3123.03",
                "due_date": "1421683200000"
            }
        ],
        "bank_accounts": [
            {
                "bank_id": "BI9000009388",
                "bank_name": "Hsbc Bank Usa - California",
                "account_number": "209***869",
                "image_url": "https://photo.pierup.com.s3.amazonaws.com/banklogos/Hsbc%20Bank%2C%20Usa.png?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1421307537&Signature=5d0TQKsDJMJicQ8HLMvD8xVPHKw%3D",
                "verified": "0",
                "user_id": "UR0000000001",
                "is_primary": "1",
                "bank_account_id": "BK0000001089",
                "type_id": "1"
            }
        ],
        "session_token": "e2e234f7-94aa-11e4-aad2-0ea81fa3d43c"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_statement_summary
description: 用户获取其指定币种的已经产生的指定账单汇总信息。<br/>
apiUrl: ${host}/user_api/v2/statement/get_statement_summary<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "currency": "USD",
    "session_token": "674c1971-7eb1-11e4-8328-32913f86e6ed",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
    "statement_id": "ST0000000154",[账单id，可以为null,若为空，则year和month必须非空]
    "year": "2014",[账单年]
    "month": "12"[账单月]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "purchases": "3446.12",
                "is_late": "0",
                "statement_date": "1419523200000",
                "min_percent": "1.00",
                "fees": "0.00",
                "annual_rate": "10.00",
                "statement_id": "ST0000002044",
                "currency": "USD",
                "last_statement_date": "1416844800000",
                "min_payment": "30.46",
                "statement_balance": "3046.12",
                "interest": "0.00",
                "payments": "400.00",
                "due_date": "1421683200000",
                "user_id": "UR0000000001",
                "previous_balance": "0.00"
            }
        ],
        "session_token": "674c1971-7eb1-11e4-8328-32913f86e6ed",
         "currency": "USD"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_statement_payments
description: 用户获取其指定币种的已经产生的指定账单的还款信息。<br/>
apiUrl: ${host}/user_api/v2/statement/get_statement_payments<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "currency": "USD",
    "session_token": "674c1971-7eb1-11e4-8328-32913f86e6ed",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
    "statement_id": "ST0000000154",[账单id，可以为null,若为空，则year和month必须非空]
    "year": "2014",[账单年]
    "month": "12"[账单月]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "total_amount": "400.00",
        "items": [
            {
                "created_date": "1417622400000",
                "bank_name": "HSBC Bank USA - California",
                "account_number": "209***869",
                "bank_account_id": "BK0000001089",
                "type_id": "1",
                "currency": "USD",
                "amount": "234.56",
                "business_name": "Pier",
                "bank_id": "BI9000009388",
                "history_type": "PAYMENT",
                "to_id": "PierAccount",
                "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/Hsbc%20Bank%2C%20Usa.png",
                "verified": "2",
                "user_id": "UR0000000001",
                "is_primary": "0",
                "payment_id": "PY0000000025",
                "notes": "payment"
            },
            {
                "created_date": "1417449600000",
                "bank_name": "HSBC Bank USA - California",
                "account_number": "209***869",
                "bank_account_id": "BK0000001089",
                "type_id": "1",
                "currency": "USD",
                "amount": "165.44",
                "business_name": "Pier",
                "bank_id": "BI9000009388",
                "history_type": "PAYMENT",
                "to_id": "PierAccount",
                "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/Hsbc%20Bank%2C%20Usa.png",
                "verified": "2",
                "user_id": "UR0000000001",
                "is_primary": "0",
                "payment_id": "PY0000000026",
                "notes": "payment"
            }
        ],
        "statement_id": "ST0000002044",
        "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
        "currency": "USD"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_user_transactions_by_time
description: 用户获取其指定币种的消费列表，以时间方式布局。<br/>
apiUrl: ${host}/user_api/v2/statement/get_user_transactions_by_time<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000002",
    "currency": "USD",
    "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
    "device_token": "eb51381f 775241e1 eed0b011 c85122f2 eefef75c e478f2e7 f4ddb363 171f0cdet",
    "statement_id": "ST0000010918",[当flag为2时有效，并且与year和month不能同时为空]
    "year": "2015",[当flag为2时有效]
    "month": "2",[当flag为2时有效]
    "flag": "2"[1表示获取未出账账单的交易信息，2表示获取指定账单的交易信息]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "created_date": "1423584000000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",[PAYMENT,INTEREST,PENALTY,REFUND,TRANSACTION]
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010688",
                "currency": "USD"
            },
            {
                "created_date": "1423584000000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010689",
                "currency": "USD"
            },
            {
                "created_date": "1423584000000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010690",
                "currency": "USD"
            },
            {
                "created_date": "1423584000000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010672",
                "currency": "USD"
            },
            {
                "created_date": "1423584000000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010683",
                "currency": "USD"
            },
            {
                "created_date": "1423584000000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010685",
                "currency": "USD"
            },
            {
                "created_date": "1423584000000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010686",
                "currency": "USD"
            },
            {
                "created_date": "1423065600000",
                "business_name": "Pier",
                "amount": "100.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "还款",
                "transaction_id": "PY0000010264",
                "currency": "USD"
            },
            {
                "created_date": "1423065600000",
                "business_name": "Pier",
                "amount": "100.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "还款",
                "transaction_id": "PY0000010265",
                "currency": "USD"
            },
            {
                "created_date": "1423065600000",
                "business_name": "Pier",
                "amount": "1.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "",
                "transaction_id": "PY0000010266",
                "currency": "USD"
            },
            {
                "created_date": "1423065600000",
                "business_name": "Pier",
                "amount": "100.00",
                "to_id": "PierAccount",
                "transaction_type": "PAYMENT",
                "category_id": "",
                "notes": "还款",
                "transaction_id": "PY0000010275",
                "currency": "USD"
            },
            {
                "created_date": "1422633600000",
                "business_name": "Diabetic Care",
                "amount": "23.29",
                "to_id": "MC0000000134",
                "transaction_type": "TRANSACTION",
                "category_id": "5",
                "notes": "transaction test",
                "transaction_id": "MT0000005803",
                "currency": "USD"
            },
            {
                "created_date": "1422288000000",
                "business_name": "Pier",
                "amount": "38.58",
                "to_id": "PierAccount",
                "transaction_type": "INTEREST",
                "category_id": "",
                "notes": "INTEREST",
                "transaction_id": "PY0000010113",
                "currency": "USD"
            }
        ],
        "statement_id": "ST0000010918",
        "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
        "currency": "USD"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_statement_all
description: 用户获取其指定币种的已经产生的所有账单。<br/>
apiUrl: ${host}/user_api/v2/statement/get_statement_all<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "currency": "USD",
    "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
    "device_token": "3e33a657 bfde3715 57ea3c34 1abc1b99 cb58512d cf00f059 e9228cda 5276256f"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "statement_date": "1419523200000",
                "statement_id": "ST0000002044",
                "statement_balance":"3046.12"
                "currency":"USD"
            }
        ],
        "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_user_transaction_detail
description: 用户获取其指定币种具体交易详情。<br/>
apiUrl: ${host}/user_api/v2/statement/get_user_transaction_detail<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
    "device_token": "3e33a657 bfde3715 57ea3c34 1abc1b99 cb58512d cf00f059 e9228cda 5276256f",
    "transaction_id": "MT0000000422"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "state_province_code": "IL",
                "created_date": "1420214400000",
                "business_name": "Amazon",
                "amount": "123.09",
                "history_type": "TRANSACTION",
                "to_id": "MC0000000011",
                "desc": "Casual Use",
                "postal_code": "50022",
                "category_id": "2",
                "notes": "Econ Textbooks",
                "transaction_id": "MT0000000422",
                "city": "Scarboro",
                "currency": "USD"
            }
        ],
        "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_user_payment_detail
description: 用户获取其指定币种具体支付或利息或罚款或退款详情。<br/>
apiUrl: ${host}/user_api/v2/statement/get_user_payment_detail<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000002",
    "currency": "USD",
    "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
    "device_token": "eb51381f 775241e1 eed0b011 c85122f2 eefef75c e478f2e7 f4ddb363 171f0cdet",
    "payment_id": "PY0000010688"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "created_date": "1423584000000",
        "bank_name": "Citibank Fsb",
        "account_number": "400**********54X",
        "bank_account_id": "BK0000009951",
        "type_id": "1",
        "currency": "USD",
        "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
        "bank_id": "BI9000018440",
        "business_name": "Pier",
        "amount": "1.00",
        "history_type": "PAYMENT",
        "to_id": "PierAccount",
        "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/BI9000001465.png",
        "verified": "2",
        "user_id": "UR0000000002",
        "payment_id": "PY0000010688",
        "is_primary": "0",
        "notes": ""
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```


### apiName: get_user_transactions_by_category
description: 用户获取其指定币种的消费列表，以商家类别方式布局。<br/>
apiUrl: ${host}/user_api/v2/statement/get_user_transactions_by_category<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "currency": "USD",
    "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
    "device_token": "3e33a657 bfde3715 57ea3c34 1abc1b99 cb58512d cf00f059 e9228cda 5276256f",
    "statement_id": "ST0000002044",[当flag为2时有效，并且与year和month不能同时为空]
    "year": "2014",[当flag为2时有效]
    "month": "12",[当flag为2时有效]
    "flag": "2"[1表示获取未出账账单的交易信息，2表示获取指定账单的交易信息]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "total_amount": "3446.12",
        "items": [
            {
                "amount": "1957.89",
                "rate": "56.81",
                "numbers": "30",
                "desc": "Casual Use",
                "category_id": "2"
            },
            {
                "amount": "1227.63",
                "rate": "35.62",
                "numbers": "13",
                "desc": "Food and Drink",
                "category_id": "4"
            }
        ],
        "statement_id": "ST0000002044",
        "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
        "currency": "USD"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_user_transactions_of_category
description: 用户获取其指定币种和商家类别的交易列表，以时间方式布局。<br/>
apiUrl: ${host}/user_api/v2/statement/get_user_transactions_of_category<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "currency": "USD",
    "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
    "device_token": "3e33a657 bfde3715 57ea3c34 1abc1b99 cb58512d cf00f059 e9228cda 5276256f",
    "statement_id": "ST0000002044",[当flag为2时有效，并且与year和month不能同时为空]
    "year": "2014",[当flag为2时有效]
    "month": "12",[当flag为2时有效]
    "flag": "1",[1表示获取未出账账单的交易信息，2表示获取指定账单的交易信息]
    "category_id": "2"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "total_amount": "95.57",
        "items": [
            {
                "created_date": "1421251200000",
                "state_province_code": "NY",
                "desc": "Charities, Education and Membership",
                "category_id": "3",
                "transaction_id": "MT0000009900",
                "currency": "USD",
                "city": "New York",
                "amount": "26.36",
                "business_name": "Pier",
                "history_type": "TRANSACTION",
                "to_id": "MC0000000017",
                "postal_code": "1222",
                "notes": "transaction test"
            },
            {
                "created_date": "1420473600000",
                "state_province_code": "NY",
                "desc": "Charities, Education and Membership",
                "category_id": "3",
                "transaction_id": "MT0000009930",
                "currency": "USD",
                "city": "New York",
                "amount": "15.76",
                "business_name": "Pier",
                "history_type": "TRANSACTION",
                "to_id": "MC0000000017",
                "postal_code": "1222",
                "notes": "transaction test"
            },
            {
                "created_date": "1420387200000",
                "state_province_code": "NY",
                "desc": "Charities, Education and Membership",
                "category_id": "3",
                "transaction_id": "MT0000009928",
                "currency": "USD",
                "city": "New York",
                "amount": "14.65",
                "business_name": "Pier",
                "history_type": "TRANSACTION",
                "to_id": "MC0000000017",
                "postal_code": "1222",
                "notes": "transaction test"
            },
            {
                "created_date": "1420214400000",
                "state_province_code": "NY",
                "desc": "Charities, Education and Membership",
                "category_id": "3",
                "transaction_id": "MT0000005809",
                "currency": "USD",
                "city": "New York",
                "amount": "13.45",
                "business_name": "Pier",
                "history_type": "TRANSACTION",
                "to_id": "MC0000000017",
                "postal_code": "1222",
                "notes": "transaction test"
            },
            {
                "created_date": "1420041600000",
                "state_province_code": "NY",
                "desc": "Charities, Education and Membership",
                "category_id": "3",
                "transaction_id": "MT0000009926",
                "currency": "USD",
                "city": "New York",
                "amount": "4.56",
                "business_name": "Pier",
                "history_type": "TRANSACTION",
                "to_id": "MC0000000017",
                "postal_code": "1222",
                "notes": "transaction test"
            },
            {
                "created_date": "1419868800000",
                "state_province_code": "",
                "desc": "Charities, Education and Membership",
                "category_id": "3",
                "transaction_id": "MT0000009886",
                "currency": "USD",
                "city": "",
                "amount": "20.79",
                "business_name": "Flower Company",
                "history_type": "TRANSACTION",
                "to_id": "MC0000000134",
                "postal_code": "",
                "notes": "transaction test"
            }
        ],
        "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
        "currency": "USD"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_statement_ifs
description: 用户获取其指定币种的已经产生的指定账单的收费信息，或者利息信息。<br/>
apiUrl: ${host}/user_api/v2/statement/get_statement_ifs<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "currency": "USD",
    "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
    "device_token": "3e33a657 bfde3715 57ea3c34 1abc1b99 cb58512d cf00f059 e9228cda 5276256f",
    "statement_id": "ST0000002044",
    "year": "2014",
    "month": "12",
    "flag": "1"[1表示获取利息信息，2表示获取收费信息]
}
```

response: <==<br/>
success message:<br/>
```JSON
{
    "code": "200",
    "message": "OK",
    "result": {
        "total_amount": "0.00",
        "items": [],
        "statement_id": "ST0000002044",
        "session_token": "8d309717-9bae-11e4-aad2-0ea81fa3d43c",
         "currency": "USD"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

## V2 INBOX API 1

### apiName: delete_inbox_message
description: 删除inbox message。<br/>
apiUrl: ${host}/user_api/v2/inbox/delete_inbox_message<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
    "inbox_id": "IB0000000269"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_message_detail_byId
description: 根据id获取inbox message详情。<br/>
apiUrl: ${host}/user_api/v2/inbox/get_message_detail_byId<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
    "inbox_id": "IB0000000269"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "image_url": "https://photo.pierup.com.s3.amazonaws.com/pier_user/icon_inbox_new.png?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1420799885&Signature=Cc5Fji%2F0MxpY7MIIGfzUmN6fbR0%3D",
                "message_detail": "Half, Half Cafe",
                "subject": "Welcome to Pier"
            }
        ],
        "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_message_abstract
description: 获取inbox message的第二级摘要列表。<br/>
apiUrl: ${host}/user_api/v2/inbox/get_message_abstract<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
    "from_user": "MC0000000017",
    "limit": "10",
    "start_inbox_id": ""
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "message_abstract": "Welcome to Pier",
                "image_url": "https://photo.pierup.com.s3.amazonaws.com/pier_user/icon_inbox_new.png?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1420799885&Signature=Cc5Fji%2F0MxpY7MIIGfzUmN6fbR0%3D",
                "created_on": "1418982070000",
                "subject": "Welcome to Pier",
                "is_read": "1",
                "pi": "1001",[page_id]
                "inbox_id": "IB0000000269"，
                "fu":"MC0000000017"[from_user]
            }
        ],
        "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_message_abstract_group_byFU
description: 根据指定的from_user列表，获取inbox message的第一级摘要列表。<br/>
apiUrl: ${host}/user_api/v2/inbox/get_message_abstract_group_byFU<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
    "from_users": [
        "MC0000000017",
        "MC0000000011"
    ]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "abstract": "Welcome to Pier",
                "is_group": "0",
                "image_url": "https://photo.pierup.com.s3.amazonaws.com/pier_user/icon_inbox_new.png?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1420799885&Signature=Cc5Fji%2F0MxpY7MIIGfzUmN6fbR0%3D",
                "created_on": "1418982070000",
                "subject": "Welcome to Pier",
                "fu": "MC0000000017",[from_user]
                "badge": "1",
                "is_read": "1",
                "pi": "1001",[page_id]
                "inbox_id": "IB0000000269"
            },
            {
                "abstract": "This is a Test.",
                "is_group": "1",
                "image_url": "",
                "created_on": "1418981987000",
                "subject": "Test Company",
                "fu": "MC0000000011",
                "badge": "1",
                "is_read": "1",
                "pi": "",
                "inbox_id": ""
            }
        ],
        "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_message_abstract_group
description: 获取inbox message的第一级摘要列表。<br/>
apiUrl: ${host}/user_api/v2/inbox/get_message_abstract_group<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed",
    "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "abstract": "Welcome to Pier",
                "is_group": "0",
                "image_url": "https://photo.pierup.com.s3.amazonaws.com/pier_user/icon_inbox_new.png?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1420799885&Signature=Cc5Fji%2F0MxpY7MIIGfzUmN6fbR0%3D",
                "created_on": "1418982070000",
                "subject": "Welcome to Pier",
                "fu": "MC0000000017",
                "badge": "1",
                "is_read": "1",
                "pi": "1001",
                "inbox_id": "IB0000000269"
            },
            {
                "abstract": "This is a Test.",
                "is_group": "1",
                "image_url": "",
                "created_on": "1418981987000",
                "subject": "Test Company",
                "fu": "MC0000000011",
                "badge": "1",
                "is_read": "1",
                "pi": "",
                "inbox_id": ""
            },
            {
                "abstract": "Simple Credit For Living A Better Life.",
                "is_group": "1",
                "image_url": "",
                "created_on": "1418981932000",
                "subject": "Pier Inc.",
                "fu": "MC0000000150",
                "badge": "2",
                "is_read": "0",
                "pi": "",
                "inbox_id": ""
            }
        ],
        "session_token": "7fabfd84-803d-11e4-8328-32913f86e6ed"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: subscribe_message
description: 用户订阅指定商家的信息。<br/>
apiUrl: ${host}/user_api/v2/inbox/subscribe_message<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "from_user": "AAA000000001",[必须商家]
    "user_id": "UR0000001045",
    "session_token": "fb47e8a4-8b54-11e4-bf80-5f7f626dfa9e",[user的]
    "device_token": "8ceef730 41341f62 01cfd113 650294bb 94d0fc8c 3d8adb97 b9195cac 7472293d"[user的]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "fb47e8a4-8b54-11e4-bf80-5f7f626dfa9e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: unsubscribe_message
description: 用户取消订阅指定商家的信息。<br/>
apiUrl: ${host}/user_api/v2/inbox/unsubscribe_message<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "from_user": "AAA000000001",[必须商家]
    "user_id": "UR0000001045",
    "session_token": "fb47e8a4-8b54-11e4-bf80-5f7f626dfa9e",[user的]
    "device_token": "8ceef730 41341f62 01cfd113 650294bb 94d0fc8c 3d8adb97 b9195cac 7472293d"[user的]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "fb47e8a4-8b54-11e4-bf80-5f7f626dfa9e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

## V2 USER SERVICE API 1
### apiName: signin
description: 用户登录api；<br/>

<ul>status_bit user 7th to 14th bits to denote nine status：
<li>Invited: the phone account whether invited.</li>
<li>BasicInfo: the phone account whether update basic user info (first name, last name, email.)</li> 
<li>billAddress:  the phone account whether push bill address into system.</li>
<li>Ssn:  the phone account whether push ssn and dob info into system.</li>
<li>linkAccount:  the phone account whether linked a bank account.</li>
<li>hasApplied:  the phone account whether has applied pier account.</li>
<li>HasCredit:  the phone account whether has a pier credit account.</li>
<li>PasscodeStatus: the status of passcode generation, whether can generate passcode.</li>
</ul>

status_bit is equal to 0, indicates there is no account for this phone.<br/><br/>

apiUrl: ${host}/user_api/v2/user/signin <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "1362164****",
    "country_code": "US",
    "password": "********",
    "device_token": "**************"
}
```

required parameter:<br/>
phone, device_token <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "***",
        "user_id": "UR0000000001",
        "session_token": "*********",
        "apply_again": "0"
    }
}
```
note: <br/>
expiration unit: second;<br/>

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

用户没有注册:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "0",
        "user_id": "",
        "session_token": ""
    }
}
```

用户password错误,剩余4次尝试机会。：<br/>
http_code: 400<br/>
```json
{
    "code": "1030",
    "message": "Sign-in failed",
    "result": {
        "left_times": "4"
    }
}
```
若一天之内连续登录失败5次则锁定一天。<br/>
```json
{
    "code": "2009",
    "message": "Your account will be locked for 24 hours due to 5 failed log-in attempt. If you have forgotten your password, you could request password reset via “forget password” link.",
    "result": {
        "left_times": "0"
    }
}
```

用户被锁定：<br/>
http_code: 400<br/>
```json
{
    "code": "1031",
    "message": "[SECURITY_ERROR] deactivated/locked user",
    "result": {
        "status_bit": "*",
        "user_id": "",
        "session_token": ""
    }
}
```

用户device token改变或者未激活：<br/>
```json
{
    "code": "1002",
    "message": "[SECURITY_ERROR] Device token is invalid or not verified",
    "result": {}
}
```

### apiName: activation_code
description: 用户请求发送激活帐号的短信验证码；<br/>
apiUrl: ${host}/user_api/v2/user/activation_code <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "1362164****",
    "country_code": "CN"
}
```

required parameter:<br/>
phone, country_code <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "expiration": "300"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

用户手机号码已经注册：<br/>
```json
{
    "code": "1140",
    "message": "The phone number has been signed up, please sign in.",
    "result": {
        "prefix_phone": "",
        "expiration": "300",
        "code": ""
    }
}
```

### apiName: activation
description: 使用用户的帐号激活短信，激活帐号生成用于创建帐号的token；<br/>
apiUrl: ${host}/user_api/v2/user/activation <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "13621643896",
    "country_code": "CN",
    "activation_code": "265633"
}
```

required parameter:<br/>
phone, country_code, activation_code <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "token": "3286d9ff5fed3765953ea9cbe9790f68"
    }
}
```

failure message:<br/>
activation_code 已经使用过了，过期，或者非法:<br/>
http_code: 400<br/>
```json
{
    "code": "2004",
    "message": "[USER] Activation code is used or expired.",
    "result": {
        "token": ""
    }
}
```

### apiName: change_device_code
description: 用户请求发送更换设备的短信验证码；<br/>
apiUrl: ${host}/user_api/v2/user/change_device_code <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "1362164****",
    "country_code": "CN"
}
```

required parameter:<br/>
phone, country_code <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {        
        "expiration": "300",
        "code_id": "85",      
        "sms_no": "0085"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

### apiName: change_device
description: 校验用户的修改设备的短信码，成功以后激活当前设备，禁用其他设备；<br/>
apiUrl: ${host}/user_api/v2/user/change_device <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "13621643896",
    "country_code": "CN",
    "code": "265633"，
    "device_token": "*****"
}
```

required parameter:<br/>
phone, country_code, code, device_token <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```

failure message:<br/>
code 已经使用过了，过期，或者非法:<br/>
http_code: 400<br/>
```json
{
    "code": "1110",
    "message": "[SMS] message code is used or invalid.",
    "result": {}
}
```

### apiName: register_user
description: 注册用户；<br/>
apiUrl: ${host}/user_api/v2/user/register_user <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
   "phone": "13621643893",
   "country_code": "CN",
   "password": "******",
   "token": "3286d9ff5fed3765953ea9cbe9790f68",
   "device_token": "test_token",
   "push_notification": "1",
   "allow_access_phonebook": "1"
}
```

required parameter:<br/>
phone, country_code, token, device_token, password <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "user_id": "UR0000010155",
        "device_id": "UD0000010156",
        "status_bit":"1",
        "session_token": "1b25828c-a8fe-11e4-8564-77a7e16f885e"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

### apiName: register_user_web
description: 注册用户；<br/>
apiUrl: ${host}/user_api/v2/user/register_user_web <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
   "phone": "13621643893",
   "country_code": "CN",
   "password": "******",
   "token": "3286d9ff5fed3765953ea9cbe9790f68",
   "device_token": "test_token",
   "push_notification": "1",
   "allow_access_phonebook": "1",
   "password_md5":"3286d9ff5fed3765953ea9cbe9790f68"
}
```

required parameter:<br/>
phone, country_code, token, device_token, password <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "user_id": "UR0000010155",
        "status_bit":"1",
        "session_token": "1b25828c-a8fe-11e4-8564-77a7e16f885e"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

### apiName: get_position
description: 查询用户在邀请队列里的位置；<br/>
apiUrl: ${host}/user_api/v2/user/get_position <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010186",
    "device_token": "eb51381f 775241e1 eed0b011 c85122f2 eefef75c e478f2e7 f4ddb363 171f0cde t"
}
```

required parameter:<br/>
user_id, device_token <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "before_count": "0",
        "after_count": "2"
    }
}
```

### apiName: distribute_invitation
description: 为count个或者指定用户分发邀请码；<br/>
apiUrl: ${host}/user_api/v2/user/distribute_invitation <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "count": "2",
    "phone": "******",
    "country_code": "US"
}
```

required parameter:<br/>
count <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "prefix_phone": "+8613621643891",
        "items": [
            {
                "prefix_phone": "+861",
                "code": "501507"
            }
        ],
        "expiration": "604800",
        "code_id": "98",
        "code": "060123",
        "sms_no": "0098"
    }
}
```

### apiName: verify_invitation
description: 校验用户的application invitation短信码，成功以后修改user的invited标志位；<br/>
apiUrl: ${host}/user_api/v2/user/verify_invitation <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "13621643896",
    "country_code": "CN",
    "code": "265633"，
    "device_token": "*****"
}
```

required parameter:<br/>
phone, country_code, code, device_token <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "77",
        "user_id": "UR0000010192",
        "session_token": "f023281a-ac18-11e4-8564-77a7e16f885e"
    }
}
```

failure message:<br/>
code 已经使用过了，过期，或者非法:<br/>
http_code: 400<br/>
```json
{
    "code": "1110",
    "message": "[SMS] message code is used or invalid.",
    "result": {}
}
```

### apiName: save_user_basic
description: 保存用户的基本信息（first_name, last_name, email）；<br/>
apiUrl: ${host}/user_api/v2/user/save_user_basic <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010206",
    "device_token": "test_token",
    "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e",
    "first_name": "Adore",
    "last_name": "CHEN",
    "email": "test2014@pierup.com"
}
```

required parameter:<br/>
user_id, device_token, session_token, first_name, last_name, email <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "205",
        "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

fail message:<br/>
mail has existed:<br/>
```json
{
    "code": "1079",
    "message": "This email is associated with another PIER account",
    "result": {
        "status_bit": "973",
        "session_token": "a053a867-ace5-11e4-8564-77a7e16f885e"
    }
}
```

### apiName: save_user_address
description: 保存用户的地址信息；<br/>
apiUrl: ${host}/user_api/v2/user/save_user_address <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010206",
    "device_token": "test_token",
    "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e",
    "address": "2810 19th Place South Homewood, AL(Alabama) 35209 "
}
```

required parameter:<br/>
user_id, device_token, session_token, address <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "461",
        "street": "2810 19th Pl S",
        "postal_code": "35209",
        "state": "AL",
        "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e",
        "city": "Birmingham"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: save_user_ssn
description: 保存用户的dob 和 ssn信息；<br/>
apiUrl: ${host}/user_api/v2/user/save_user_ssn <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010206",
    "device_token": "test_token",
    "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e",
    "dob": "03/21/1988",
    "ssn": "123456780"
}
```

required parameter:<br/>
user_id, device_token, session_token, dob, ssn <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "973",
        "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: update_user
description: 更新用户信息；<br/>
apiUrl: ${host}/user_api/v2/user/update_user <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010206",
    "device_token": "test_token",
    "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e",
    "first_name": "Adore",
    "last_name": "CHEN",
    "email": "test2014@pierup.com",
    "dob": "03/21/1988",
    "ssn": "123456780",
    "address": "2810 19th Place South Homewood, AL(Alabama) 35209 "
}
```

required parameter:<br/>
user_id, device_token, session_token<br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "973",
        "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

mail has existed:<br/>
```json
{
    "code": "1079",
    "message": "This email is associated with another PIER account",
    "result": {
        "status_bit": "973",
        "session_token": "a053a867-ace5-11e4-8564-77a7e16f885e"
    }
}
```

### apiName: get_user
description: 查询该用户的user相关信息；<br/>
apiUrl: ${host}/user_api/v2/user/get_user <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010206",
    "device_token": "test_token",
    "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e"
}
```

required parameter:<br/>
user_id, device_token, session_token <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "first_name": "Adore",
        "email": "test2014@pierup.com",
        "address": "2810 19th Pl S\nBirmingham, AL 35209",
        "dob": "574876800000",
        "last_name": "CHEN",
        "ssn": "*****1111",
        "user_id": "UR0000010206",
        "session_token": "13211af4-addd-11e4-8564-77a7e16f885e"
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: sms_password_forget
description: 忘记密码，请求发送短信重置密码；<br/>
apiUrl: ${host}/user_api/v2/user/sms_password_forget <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "1362164****",
    "country_code": "CN"
}
```

required parameter:<br/>
phone, country_code <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "expiration": "60",
        "sms_no": "N0014"
    }
}
```
note: <br/>
expiration unit: second;<br/>

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

### apiName: sms_password_check
description: 忘记密码时，校验发送的短信验证码；<br/>
apiUrl: ${host}/user_api/v2/user/sms_password_check <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "1362164****",
    "country_code": "CN",
    "code": "430400"
}
```

required parameter:<br/>
phone, country_code, code <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "token": "3b1802a52354c6cfc95fea8c965da667"
    }
}
```
note: <br/>
expiration unit: second;<br/>

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

短信验证码过期：<br/>
http_code: 400<br/>
```json
{
    "code": "1111",
    "message": "[SMS] message code is expired.",
    "result": {}
}
```

### apiName: sms_password_reset
description: 忘记密码时，校验发送的短信验证码；<br/>
apiUrl: ${host}/user_api/v2/user/sms_password_reset <br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "token": "3b1802a52354c6cfc95fea8c965da667",
    "password": "***********"
}
```

required parameter:<br/>
all <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```
note: <br/>
expiration unit: second;<br/>

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter token is missing.",
    "result": null
}
```

重置密码的token过期：<br/>
http_code: 400<br/>
```json
{
    "code": "1114",
    "message": "[Token] token is expired.",
    "result": {}
}
```

重置密码的token已经使用过：<br/>
```json
{
    "code": "1113",
    "message": "[SMS] Token of resetting password has used.",
    "result": {}
}
```

### apiName: reset_user_password
API: [host]/user_api/v2/user/reset_user_password<br/>
protocl: HTTPS<br/>

Method: POST<br/>

INPUT: user_id，old_password，new_password,platform,session_token,device_token<br/>

Note: platform:optional,value(0:IOS ;1:WEB)<br/>

OUTPUT: code, message,session_token<br/>



example:<br/>
[host]/pier_api/v1/user/reset_user_password<br/>


```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "XXXXXXXXXXXXXXXXXXXXXXX"
    }
}

```

### apiName: update_userInfo
API: [host]/user_api/v2/user/update_userInfo<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id，first_name，last_name,email,address,platform,session_token,device_token<br/>

Note: platform:optional,value(0:IOS ;1:WEB)<br/>

OUTPUT: code, message,session_token<br/>



example:<br/>
[host]/user_api/v1/user/update_userInfo<br/>


```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "XXXXXXXXXXXXXXXXXXXXXXX"
    }
}

```

### apiName: get_userStatusBit
API: [host]/user_api/v2/user/get_userStatusBit<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id[requried]，session_token[requried]，currency_code[requried],dev_info(default 0),device_token

OUTPUT: code, message,session_token,status_code,decline_msg,status_bit<br/>

example:<br/>

```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "decline_msg": "OK",
        "session_token": "a80c124e-5f46-11e4-b4fe-22000a1ca299",
        "status_bit": "13"
    }
}

```

### apiName: get_user_info_ex
API: [host]/user_api/v2/user/get_user_info_ex<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token<br/>

example:<br/>

```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "addressinfo": [
            {
                "state_province_code": "hdhe",
                "address_id": "AD0000001128",
                "postal_code": "hshs",
                "address_1": "js",
                "is_primary": "1",
                "address_type": "",
                "country_code": "US",
                "city": "gdh"
            }
        ],
        "cardinfo": [
            {
                "card_type": "1",
                "card_id": "B6451894"
            },
            {
                "card_type": "1",
                "card_id": "GF970670"
            },
            {
                "card_type": "3",
                "card_id": "hdhs"
            }
        ],
        "userinfo": [
            {
                "first_name": "hsjs",
                "image_url": "https://photo.pierup.com.s3.amazonaws.com/pier_user/UR0000000014_profile.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1420037045&Signature=rc8J3BtRq%2Btjih7AbjqJnpmBEsM%3D",
                "primary_email": "evenliu0410@gmail.com",
                "status_bit": "397",
                "dob": "1419523200000",
                "ssn": "154846236",
                "last_name": "hdj",
                "user_id": "UR0000000014",
                "last_logon": "1420008201000",
                "country_code": "CN"
            }
        ],
        "session_token": "52ba086c-9009-11e4-aad2-0ea81fa3d43c"
    }
}

```

### apiName: get_userInfo
API: [host]/user_api/v2/user/get_userInfo<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token<br/>

OUTPUT: code, message,session_token,status_code,user_id,country_code,first_name,image_url,last_logon,last_name,phone,
primary_email,ssn,status_bit<br/>


example:<br/>

```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "country_code": "CN",
        "first_name": "wang",
        "user_id": "UR0000000232",
        "image_url": null,
        "last_logon": "2014-10-29 08:36:19.0",
        "last_name": "bei",
        "phone": "18818235798",
        "primary_email": "123456@qq.com",
        "session_token": "a80c124e-5f46-11e4-b4fe-22000a1ca299",
        "ssn": null,
        "status_bit": "13"
    }
}

```

### apiName: get_nearby_user_info
API: [host]/user_api/v2/user/get_nearby_user_info<br/>

Method: GET<br/>
protocl: HTTPS<br/>
INPUT: user_id，nearby_user_id,session_token，device_token<br/>

OUTPUT: first_name, last_name,img_url,session_token,code<br/>


example:<br/>

```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "first_name": "wang",
        "img_url": null,
        "last_name": "bei",
        "session_token": "a80c124e-5f46-11e4-b4fe-22000a1ca299",
    }
}

```

### apiName: get_bankInfo
API: [host]/user_api/v2/user/get_bankInfo<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: routing_no<br/>

OUTPUT: code, message,address,bank_name,city,phonenumber,postcode,state,routing_no<br/>

example:<br/>


```json
{
"code": "200",
"message": "OK",
"result": [
{ 
"bank_id":"xxxxxxxxxxxxxxxxxxxx"
"address": "PO BOX 27025", 
"bank_name": "Bank Of America N.a.", 
"city": "RICHMOND", 
"phonenumber": "800-446-0135", 
"postcode": "23261", 
"routing_no": "11302438",
"state": "VA" 
}
]
}
```

### apiName: get_all_state_provinces
API: [host]/pier_api/v2/user/get_all_state_provinces<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token<br/>

OUTPUT: code, message，country_code，desc，sort，state_code<br/>


```json
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "country_code": "CN",
                "desc": "北京市",
                "sort": "1",
                "state_code": "01",
                "state_label":"北京市"
            },
            {
                "country_code": "CN",
                "desc": "天津市",
                "sort": "1",
                "state_code": "02",
                "state_label":"天津市"
            },
            {
                "country_code": "CN",
                "desc": "上海市",
                "sort": "1",
                "state_code": "03",
                "state_label":"上海市"
            },
            {
                "country_code": "CN",
                "desc": "重庆市",
                "sort": "1",
                "state_code": "04",
                "state_label":"重庆市"
            },
            {
                "country_code": "US",
                "desc": "Alaska",
                "sort": "1",
                "state_code": "AK",
                "state_label":"AK"
            },
            {
                "country_code": "US",
                "desc": "Alabama",
                "sort": "1",
                "state_code": "AL",
                "state_label":"AL"
            },
            {
                "country_code": "US",
                "desc": "Arkansas",
                "sort": "1",
                "state_code": "AR",
                "state_label":"AR"
            },
            {
                "country_code": "US",
                "desc": "Arizona",
                "sort": "1",
                "state_code": "AZ",
                "state_label":"AZ"
            },
           .........
        ]
    }
}

```

### apiName: get_countries
API:  [host]/user_api/v2/user/get_countries<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: None<br/>

Stored Procedure: get_countries()<br/>

API sample output: <br/>
```json
{
"code":"200",
"message":"OK",
"result": [
     { "country_code":"US","country_name":"United States","phone_prefix":"1","phone_size":10},
     { "country_code":"CN","country_name":"China","phone_prefix":"86","phone_size":11}
   ]
}
```

### apiName: sign_out
API: [host]/user_api/v2/user/sign_out<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token<br/>

OUTPUT: code, message<br/>


```json
{
    "code": "200",
    "message": "OK",
    "result": null
}

```

### apiName: signout_security
API: [host]/user_api/v2/user/signout_security<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token<br/>

OUTPUT: code, message<br/>


```json
{
    "code": "200",
    "message": "OK",
    "result": null
}

```

### apiName: add_user_bank
API: [host]/user_api/v2/user/add_user_bank<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id，bank_id，account_no，account_type_id，is_primary，session_token，device_token<br/>

OUTPUT: code, message,session_token<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result":
{ "session_token": "eab974d9-60bf-11e4-9a7e-9e9a27f350b5" }
}
```

### apiName: get_user_bank_accounts
API: [host]/user_api/v2/user/get_user_bank_accounts<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token<br/>

OUTPUT: code, message,session_token,status_code，account_number，bank_account_Id，bank_id，bank_name，is_primary，type_id，user_id，verified<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result": {
"items": [
{ 
"account_number": "123456789012345",
"bank_account_Id": "BK0000000278", 
"bank_id": "BI9000000015", 
"bank_name": "Merrimack County Svgs Bank",
"is_primary": "0", 
"type_id": "1", 
"user_id": "UR0000000232", 
"verified": "0" 
}
],
"session_token": "314286fb-60c7-11e4-9a7e-9e9a27f350b5"
}
}
```

### apiName: get_addresses
API: [host]/user_api/v2/user/get_addresses<br/>

Method: GET<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token<br/>

OUTPUT: code, message,session_token,status_code,address_id,address_1,city,country_code,is_primary,postal_code,state_province_code,address_type<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result": {
"items": [
{ 
"address_1": "TEST_address1_002", 
"city": "上海市",
"country_code": "CN", 
"address_id": "AD0000000273", 
"is_primary": "0", 
"postal_code": "20000",
"state_province_code": "03" 
},
{ 
"address_1": "TEST_address2_003", 
"city": "SHANGHAI",
"country_code": "CN", 
"address_id": "AD0000000274",
"is_primary": "0",
"postal_code": "20000",
"state_province_code": "03" 
},
{ "address_1": "TEST_address2_003",
"city": "SHANGHAI", 
"country_code": "CN", 
"address_id": "AD0000000275", 
"is_primary": "0", 
"postal_code": "20000", 
"state_province_code": "03" 
},
{
"address_1": "TEST_address2_0033",
"city": "SHANGHAI", 
"country_code": "CN",
"ID": "AD0000000276",
"is_primary": "1",
"postal_code": "20000", 
"state_province_code": "03" 
},
{ "address_1": "TEST_address1_0023",
"address_2": "TEST_address2_0023", 
"city": "上海市", 
"country_code": "CN", 
"address_id": "AD0000000280", 
"is_primary": "0", 
"postal_code": "20000",
"state_province_code": "03" 
}
],
"session_token": "eaf2b7e3-6017-11e4-9a7e-9e9a27f350b5"
}
}
```

### apiName: update_address
API: [host]/user_api/v2/user/update_address<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token，address1，address2，city,state_code,country_code,postal_code,is_primary,address_type,address_id<br/>

OUTPUT: code, message,address_id,session_token,status_code<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result":
{ 
"session_token": "a80c124e-5f46-11e4-b4fe-22000a1ca299"
}

}
```


### apiName: add_address
API: [host]/user_api/v2/user/add_address<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token，address1，address2，city,state_code,country_code,postal_code,is_primary,address_type<br/>

OUTPUT: code, message,address_id,session_token,status_code<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result":
{ 
“address_id”：“AD0000000273”，
"session_token": "a80c124e-5f46-11e4-b4fe-22000a1ca299"
}

}
```

### apiName: deactive_address
API: [host]/user_api/v2/user/deactive_address<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id，session_token，device_token，address_id<br/>

OUTPUT: code, message,address_id,session_token,status_code<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result":
{ 
"session_token": "a80c124e-5f46-11e4-b4fe-22000a1ca299"
}

}
```

### apiName: set_primary_address
API: [host]/user_api/v2/user/set_primary_address<br/>

Method: POST<br/>
rotocl: HTTPS<br/>

INPUT: user_id，address_id，session_token，device_token<br/>

OUTPUT: code, message,session_token,status_code<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result":
{ 
"session_token": "a80c124e-5f46-11e4-b4fe-22000a1ca299"
}

}
```

### apiName: is_active
API: [host]/user_api/v2/user/is_active<br/>

Method: POST<br/>
rotocl: HTTPS<br/>

INPUT: country_code，phone，device_token<br/>

Note: platform:optional,value(0:IOS ;1:WEB)<br/>

OUTPUT: code, message,has_actived<br/>


example:<br/>


```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "has_actived": "0"
    }
}

```

### apiName: register1
API: [host]/user_api/v2/user/register1<br/>

METHOD: POST<br/>
rotocl: HTTPS<br/>

API Input: country_code, phone, platform, push_notification, allow_access_phonebook, device_token
(note: value of “push_notification”, “allow_access_phonebook” should be 0/1)<br/>

Example:<br/>
> curl -X POST —d “country_code=US&phone=6662223333&platform=IOSAPI&push_notification=1&allow_access_phonebook=1&device_token=XXXX” [host]/pier_api/v1/user/register1<br/>

API OUTPUT:  message, activation_code, device_id, session_token, user_id<br/>

example:<br/>
```json
{
“code”: "200"
“message”: "OK"
“result”: {
     “activation_code”: "2947"
     “device_id”: "UD0000000004"
     “session_token”: "17871386-4795-11e4-8963-22000a1ca299"
     “user_id”: "UR0000000003"
   }
}
```

### apiName: verify_device
API: [host]/user_api/v2/user/verify_device<br/>

Method: POST<br/>
rotocl: HTTPS<br/>

INPUT: user_id, device_id, activation_code<br/>

OUTPUT: STATUS_CODE, message <br/>

example:<br/>
```json
{
"code":"200",
"message":"OK"
"result": {}  
}
```

### apiName: register2
API: [host]/user_api/v2/user/register2<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id, last_name, first_name, password, email, session_token, device_token<br/>

OUTPUT: STATUS_CODE, message, session_token<br/>

example:<br/>
```json
{
"code":"200",
"message":"OK", 
"result": {
   “session_token”:”[token]”
   }
}
```

### apiName: add_card
API: [host]/user_api/v2/user/add_card<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id，[required]<br/>
session_token，[required]<br/>
device_token,[required]<br/>
card_type，[required]<br/>
card_id，[required]<br/>
last_name，[required]<br/>
first_name，[required]<br/>
street，<br/>
city，<br/>
state_code，<br/>
country_code，<br/>
postal_code，<br/>
issue_date，<br/>
expired_date<br/>
optional_date1<br/>
optional_date2	<br/>
dob<br/>

			
			

OUTPUT: code, message,session_token,address_id<br/>

example:<br/>

```json
{
"code": "200",
"message": "OK",
"result":
{ "session_token": "eab974d9-60bf-11e4-9a7e-9e9a27f350b5","address_id":"XXXXXXXXXXXXXXXXXXXXXXXXXXXX" }
}
```

### apiName: check_phone_book
API: [host]/user_api/v2/user/check_phone_book<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: phone_num - array of phone, example: phone_num=XXXXXX;YYYYYYY;ZZZZZ (separate by ; )<br/>

Example:<br/>
> curl -X POST —d “phone_num=XXXXXX;YYYYYYY;ZZZZZ” [host]/pier_api/v1/user/check_phone_book<br/>

OUTPUT: STATUS_CODE, message, hashmap of phone#/boolean<br/>
```json
{
“code”: "200"
“message”: "OK"
“result”: {
     { "phoneNo": "YYYYYYY", "status": false },
     { "phoneNo": "ZZZZZ", "status": false },
     { "phoneNo": "XXXXXX", "status": false } 
}
}
```

### apiName: upload_file
API: [host]/user_api/v2/user/upload_file<br/>

Method: POST<br/>
protocl: HTTPS<br/>

INPUT: user_id, session_token, device_token, content_type, file(multi-part)<br/>

```
NOTE: content_type supports one of these: 
  - "image/jpeg"
  - "image/gif"             
  - "image/bmp"
  - "image/png"
  - "image/tiff"
```

Example:<br/>
> curl --form "user_id={user_id}" --form "session_token={token}" --form "device_token={device_token}" --form "content_type=image/jpeg" --form "file=@{local_file_path}" {host}/pier_api/v1/user/upload_file<br/>

OUTPUT: STATUS_CODE, message, url, session_token<br/>
```json
{
“code”: "200"
“message”: "OK"
“result”: {
      “url”: https://...........,
      “session_token”: XXXXXXXXX
    }
}
```

### apiName: forget_password
description: 用户忘记密码时，生成临时密码；<br/>
apiUrl: ${host}/user_api/v2/user/forget_password <br/>
method: POST<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "13621643896",
    "country_code": "CN",
    "device_token": "test_token"
}
```

required parameter:<br/>
phone, country_code, device_token <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
    }
}
```

fail message:<br/>
```json
{
    "code": "1007",
    "message": "User not found",
    "result": {       
    }
}
```

fail message:<br/>
```json
{
    "code": "1002",
    "message": "Device token is invalid or not verified",
    "result": {}
}
```

### apiName: reset_password
description: 设置新的密码；<br/>
apiUrl: ${host}/user_api/v2/user/reset_password <br/>
method: POST<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "13621643896",
    "country_code": "CN",
    "device_token": "test_token",
    "session_token": "######",
    "password": "#######"
}
```

required parameter:<br/>
phone, country_code, device_token, session_token, password <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "dde86188-bf12-11e4-8564-77a7e16f885e"
    }
}
```

fail message:<br/>
```json
{
    "code": "1007",
    "message": "User not found",
    "result": {       
    }
}
```

fail message:<br/>
```json
{
    "code": "1002",
    "message": "Device token is invalid or not verified",
    "result": {}
}
```


## V2 MERCHANT USER SDK (IOS) 1

### apiName: get_agreement GET
description: 返回pier信用卡相关条款的url地址；<br/>
apiUrl: ${host}/user_api/v2/sdk/get_agreement<br/>
method: GET<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

response: <br/>
sucess message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "url_privacy": "http://pierup.ddns.net:8686/umsite/ios/1/privacy.html",
        "url_term": "http://pierup.ddns.net:8686/umsite/ios/1/terms.html"
    }
}
```

### apiName: transaction_sms
description: 用户请求发送交易短信验证码；<br/>
apiUrl: ${host}/user_api/v2/sdk/transaction_sms <br/>
method: POST<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "13621643896",
    "country_code": "CN",  
    "password": "wq",
    "session_token": "***",
    "merchant_id": "MC0000000017",
    "amount": "199.00",
    "currency_code": "USD"
}
```

required parameter:<br/>
phone, country_code, [password | session_token], merchant_id, amount, currency_code <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "prefix_phone": "+8623621643896",
        "expiration": "120",
        "status_bit": "77",
        "sms_no": "0795",
        "session_token": "9aa6fa34-c259-11e4-8564-77a7e16f885e"
    }
}
```
note: <br/>
expiration unit: second;<br/>

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter phone is missing.",
    "result": null
}
```

### apiName: save_passcode
description: save the passcode produced by phone every 30 seconds；<br/>
apiUrl: ${host}/user_api/v2/sdk/save_passcode <br/>
method: POST<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010206",
    "device_token": "test_token",
    "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e",
    "passcode": "1234567"
}
```

required parameter:<br/>
user_id, device_token, session_token, passcode <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e"
    }
}
```


failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter user_id is missing.",
    "result": null
}
```

passcode status is closed.<br/>
http_code: 400<br/>
```json
{
    "code": "2008",
    "message": "Passcode status is closed, please open it.",
    "result": null
}
```

### apiName: switch_passcode
description: switch passcode status.<br/>
apiUrl: ${host}/user_api/v2/sdk/switch_passcode <br/>
method: POST<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB； 2 indicates IOS SDK, 3 indicates Javascript SDK.<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000010206",
    "device_token": "test_token",
    "session_token": "2e947a5e-ac41-11e4-8564-77a7e16f885e",
}
```

required parameter:<br/>
user_id, device_token, session_token <br/>

response: <br/>
sucess message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "status_bit": "15309",
        "user_id": "UR0000000002",
        "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e"
    }
}
```


failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter user_id is missing.",
    "result": null
}
```

### apiName: get_auth_token POST
description: input phone and pass_code(password or text message or passcode) to produce authorization token；<br/>
apiUrl: ${host}/user_api/v2/sdk/get_auth_token<br/>
method: POST<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "phone": "13621643896",
    "country_code": "CN",
    "pass_code": "247338",
    "pass_type": 1,
    "merchant_id": "MC0000000017",
    "amount": "199.00",
    "currency_code": "USD",
    "session_token": "353b22a4-bf2f-11e4-8564-77a7e16f885e"
}
```

required parameter:<br/>
all <br/>

note:<br/>
pass_code: password or text message or passcode produced by phone.<br/>
<ul>pass_type:
<li> 1 indicates pass_code content is text message. </li>
<li> 2 indicates pass_code content is passcode produced by phone. </li>
</ul>

response: <br/>
sucess message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "auth_token": "f31d080c1ccb11f3e31b6d738195d77a"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter password is missing.",
     "result": null
}
```

短信验证码过期:<br/>
http_code: 401<br/>
```json
{
    "code": "1111",
    "message": "[SMS] message code is expired.",
    "result": {
        "auth_token": ""
    }
}
```

该用户没有信用卡帐号：<br/>
http_code: 400<br/>
```json
{
    "code": "3000",
    "message": "[Transaction] NOT FOUND credit card for this currency.",
    "result": {
        "auth_token": null
    }    
}
```

### apiName: apply_credit
description: 申请pier审批授权，返回用户信用卡额度；<br/>
apiUrl: ${host}/user_api/v2/sdk/apply_credit<br/>
method: POST<br/>
protocl: HTTPS

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "user_id": "UR0000000002",
    "session_token": "84999578-8c2f-11e4-a11f-22000b7b83e0",
    "device_token": "c496225b 8affec8c dfeba326 2131ff2d 14a4a142 0531aa7e 2bb56e79 2b96cb9f",
    "currency_code": "USD",
    "code":"0001048574"[10或者6位邀请码，可以为null]
}
```

required parameter:<br/>
user_id, session_token;<br>
currency_code 为空时默认给USD <br/>

response: <br/>
sucess message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
    	  "currency": "USD",
        "category": "SubPrime",
        "credit_limit": "250.00",
        "shadow_limit": "250.00",
        "note": "",
        "session_token": "73ed40ff-804e-11e4-8328-32913f86e6ed"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter currency_code is missing.",
    "result": null
}
```

session_token过期:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "app_id": "",
        "session_token": ""
    }
}
```

每隔一段时间才能申请：<br/>
```json
{
    "code": "1115",
    "message": "[Credit] Warning: Once application at one hour. ",
    "result": {
        "app_id": "",
        "session_token": "73ed40ff-804e-11e4-8328-32913f86e6ed"
    }
}
```

一个用户只能有一张该币种的pier信用卡<br/>
```json
{
    "code": "1116",
    "message": "[Credit] Error: You have haven a pier credit card for this currency.",
    "result": {
        "app_id": "",
        "session_token": "73ed40ff-804e-11e4-8328-32913f86e6ed"
    }
}
```
审批没有通过：<br/>
http_code: 400<br/>
```json
{
    "code": "1101",
    "message": "[Credit] Sorry, your application has been declined.",
    "result": {
        "category": "SubPrime",
        "credit_limit": "-1.00",
        "shadow_limit": "-1.00",
        "note": "Sorry, you haven't exceed 18 years old.",
        "session_token": "73ed40ff-804e-11e4-8328-32913f86e6ed"
    }
}
```

## V2 CONTANCTS API 1
### apiName: get_user_version
description: 获取当前用户相关的版本。<br/>
apiUrl: ${host}/user_api/v2/contacts/get_user_version<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000002",
    "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
    "device_token": "eb51381f 775241e1 eed0b011 c85122f2 eefef75c e478f2e7 f4ddb363 171f0cde t"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "version_key": "contacts",
                "version_value": "6"
            }
        ],
        "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: upload_user_contacts
description: 上传用户联系列表。<br/>
apiUrl: ${host}/user_api/v2/contacts/upload_user_contacts<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000002",
    "contacts": [
        {
            "phone": "18638998588",
            "email": "zy@qq.com"
        },
        {
            "phone": "13333333333",
            "email": "sjsj@ss.com"
        },
        {
            "phone": "1234567899",
            "email": "tjtj@ss.com"
        }
    ]
}
```

response: <==<br/>
success message:<br/>
```JSON
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_user_contacts
description: 获取用户联系列表中已经在pier注册过的用户列表。<br/>
apiUrl: ${host}/user_api/v2/contacts/get_user_contacts<br/>
method: POST<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000002",
    "session_token": "4e50454d-8a91-11e4-bf80-5f7f626dfa9e",
    "device_token": "eb51381f 775241e1 eed0b011 c85122f2 eefef75c e478f2e7 f4ddb363 171f0cde t",
    "version": "0"
}
```

response: <==<br/>
success message:<br/>
```josn
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "first_name": "Flower",
                "phone": "1234567890",
                "email": "cheng_cong123@163.com",
                "image_url": "",
                "last_name": "Cheng",
                "country_code": "US"
            },
            {
                "first_name": "Wang",
                "phone": "18818235798",
                "email": "hmily-xinxiang@163.com",
                "image_url": "http://photo.pierup.com.s3.amazonaws.com/UR0000000002_profile.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1739003182&Signature=1wo99ZJ6DKOpiMQXnhYC8gk%2B89Y%3D",
                "last_name": "Bei",
                "country_code": "CN"
            },
            {
                "first_name": "cell",
                "phone": "5554787672",
                "email": "sjsj@ss.com",
                "image_url": "https://photo.pierup.com.s3.amazonaws.com/pier_user/UR0000000002_profile.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1422193334&Signature=podhw%2B79nrqKtmF4%2FDEC6pI3vzE%3D",
                "last_name": "table",
                "country_code": "US"
            },
            {
                "first_name": "hsjs",
                "phone": "5555228243",
                "email": "evenliu0410@gmail.com",
                "image_url": "",
                "last_name": "hdj",
                "country_code": "US"
            }
        ],
        "session_token": "",
        "version": "1090"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: getInvitationInfo
description: 获取用户邀请信息。<br/>
apiUrl: ${host}/user_api/v2/contacts/getInvitationInfo<br/>
method: GET<br/>
protocl: HTTPS<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
user_id:用户表示；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "message": "OK",
    "result": {
        "down_url": "http://pierup.ddns.net:8686/down/app",
        "invitation_code": "0001048574"
    },
    "code": "200"
}
```


## USERSUPPORT API 1
### apiName:register_customer_rep
description: 客服注册。<br/>
apiUrl: ${host}/user_api/v1/support/register_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "rep_id": "pier.com",
    "password": "pier.com"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
    	"session_token":"d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1125",
    "message": "[SERVICE] This name of customer service has added and is actived",
    "result": {}
}
```

### apiName:update_customer_rep_password
description: 客服更改密码操作。<br/>
apiUrl: ${host}/user_api/v1/support/update_customer_rep_password<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "rep_id": "pier.com",
    "password": "pier.com",
    "session_token":"sjh-sduysu-2ndi3i"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
    	"session_token":"sjh-sduysu-2ndi3i"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName:delete_customer_rep
description: 删除客服。<br/>
apiUrl: ${host}/user_api/v1/support/delete_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "rep_id": "pier.com",
    "session_token":"sjh-sduysu-2ndi3i"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
    	"session_token":"sjh-sduysu-2ndi3i"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName:signin_customer_rep
description: 客服登入。<br/>
apiUrl: ${host}/user_api/v1/support/signin_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "rep_id": "pier.com",
    "password": "pier.com"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1126",
    "message": "[SERVICE] This customer service is not exists or unactived",
    "result": {
        "service_id": ""
    }
}
```

### apiName:signout_customer_rep
description: 客服登出。<br/>
apiUrl: ${host}/user_api/v1/support/signout_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "rep_id": "pier.com",
    "session_token": "68beb225-a83d-11e4-8564-77a7e16f885e"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```


### apiName:add_dispute_customer_rep
description: 添加dispute。<br/>
apiUrl: ${host}/user_api/v1/support/add_dispute_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "transaction_id": "MT0000000030",
    "rep_id": "pier.com",
    "reason": "dispute",
    "session_token":"d5446baf-a831-11e4-8564-77a7e16f885e"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

```json
{
    "code": "1129",
    "message": "[SERVICE] The transaction is not exists.",
    "result": {}
}
```


### apiName:do_dispute_customer_rep
description: 客服进行dispute处理流程。<br/>
apiUrl: ${host}/user_api/v1/support/do_dispute_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "dispute_support_id": "DS0000010130",
    "rep_id": "pier.com",
    "status": "2",[dispute处理状态，目前对应四种客服操作：1-initial,2-survey,3-handler,4-finish]
    "comments": "survey",
    "last_update": "2015-01-30 13:36:52",
    "session_token":"d5446baf-a831-11e4-8564-77a7e16f885e"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```
fail message:<br/>
```json
{
    "code": "1130",
    "message": "[SERVICE] The dispution is not exists.",
    "result": {}
}
```
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

```json
{
    "code": "1131",
    "message": "[SERVICE] Option of the dispution has been done by other.",
    "result": {}
}
```

### apiName:search_transactions_customer_rep
description: 搜索用戶交易列表。<br/>
apiUrl: ${host}/user_api/v1/support/search_transactions_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "transaction_id": "MT0000000030",[可空，与phone,email不能同时为空]
    "phone": "18638998588",[可空，与transaction_id,email不能同时为空]
    "email":"hujun.qu@whatever.com"，[可空，与transaction_id,phone不能同时为空]
    "country_code": "CN",
    "start_date":"2014-11-29",
    "end_date":"2015-01-30",
    "rep_id": "pier.com",
    "session_token":"d5446baf-a831-11e4-8564-77a7e16f885e"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "amount": "123.09",
                "status": "0",
                "created_on": "1420281357000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "Econ Textbooks",
                "transaction_id": "MT0000000422",
                "currency": "USD"
            },
            {
                "amount": "76.91",
                "status": "0",
                "created_on": "1419868800000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000010",
                "notes": "",
                "transaction_id": "MT0000000096",
                "currency": "USD"
            },
            {
                "amount": "123.09",
                "status": "0",
                "created_on": "1419244489000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "",
                "transaction_id": "MT0000000397",
                "currency": "USD"
            },
            {
                "amount": "7.21",
                "status": "0",
                "created_on": "1419240957000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000010",
                "notes": "Game",
                "transaction_id": "MT0000000418",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "status": "0",
                "created_on": "1419240889000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000156",
                "notes": "",
                "transaction_id": "MT0000000391",
                "currency": "USD"
            },
            {
                "amount": "76.91",
                "status": "0",
                "created_on": "1419240889000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000010",
                "notes": "Game Supply",
                "transaction_id": "MT0000000393",
                "currency": "USD"
            },
            {
                "amount": "123.78",
                "status": "0",
                "created_on": "1419237357000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000414",
                "currency": "USD"
            },
            {
                "amount": "33.00",
                "status": "0",
                "created_on": "1419237356000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000412",
                "currency": "USD"
            },
            {
                "amount": "33.00",
                "status": "0",
                "created_on": "1419237289000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000387",
                "currency": "USD"
            },
            {
                "amount": "123.78",
                "status": "0",
                "created_on": "1419237289000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000389",
                "currency": "USD"
            },
            {
                "amount": "30.56",
                "status": "0",
                "created_on": "1419233689000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000586",
                "transaction_id": "MT0000000383",
                "currency": "USD"
            },
            {
                "amount": "70.00",
                "status": "0",
                "created_on": "1419230156000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000385",
                "transaction_id": "MT0000000404",
                "currency": "USD"
            },
            {
                "amount": "70.00",
                "status": "0",
                "created_on": "1419230088000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000385",
                "transaction_id": "MT0000000379",
                "currency": "USD"
            },
            {
                "amount": "204.75",
                "status": "0",
                "created_on": "1419230088000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000476",
                "transaction_id": "MT0000000381",
                "currency": "USD"
            },
            {
                "amount": "150.00",
                "status": "0",
                "created_on": "1419226556000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000163",
                "transaction_id": "MT0000000402",
                "currency": "USD"
            },
            {
                "amount": "23.45",
                "status": "0",
                "created_on": "1419226556000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "CH0000000065",
                "transaction_id": "MT0000000400",
                "currency": "USD"
            },
            {
                "amount": "23.45",
                "status": "0",
                "created_on": "1419226547000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "CH0000000065",
                "transaction_id": "MT0000000399",
                "currency": "USD"
            },
            {
                "amount": "150.00",
                "status": "0",
                "created_on": "1419226488000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000163",
                "transaction_id": "MT0000000377",
                "currency": "USD"
            },
            {
                "amount": "23.45",
                "status": "0",
                "created_on": "1419226488000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "CH0000000065",
                "transaction_id": "MT0000000375",
                "currency": "USD"
            },
            {
                "amount": "123.09",
                "status": "0",
                "created_on": "1419065475000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "",
                "transaction_id": "MT0000000312",
                "currency": "USD"
            },
            {
                "amount": "33.00",
                "status": "0",
                "created_on": "1419058274000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000302",
                "currency": "USD"
            },
            {
                "amount": "23.45",
                "status": "0",
                "created_on": "1419047473000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "CH0000000065",
                "transaction_id": "MT0000000290",
                "currency": "USD"
            },
            {
                "amount": "123.09",
                "status": "0",
                "created_on": "1418917010000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "",
                "transaction_id": "MT0000000256",
                "currency": "USD"
            },
            {
                "amount": "9.10",
                "status": "0",
                "created_on": "1418913410000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000010",
                "notes": "recharge game account",
                "transaction_id": "MT0000000252",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "status": "0",
                "created_on": "1418913409000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000156",
                "notes": "",
                "transaction_id": "MT0000000250",
                "currency": "USD"
            },
            {
                "amount": "123.78",
                "status": "0",
                "created_on": "1418909809000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000248",
                "currency": "USD"
            },
            {
                "amount": "33.00",
                "status": "0",
                "created_on": "1418909809000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000246",
                "currency": "USD"
            },
            {
                "amount": "30.56",
                "status": "0",
                "created_on": "1418906209000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000586",
                "transaction_id": "MT0000000242",
                "currency": "USD"
            },
            {
                "amount": "204.75",
                "status": "0",
                "created_on": "1418902609000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000476",
                "transaction_id": "MT0000000240",
                "currency": "USD"
            },
            {
                "amount": "70.00",
                "status": "0",
                "created_on": "1418902609000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000385",
                "transaction_id": "MT0000000238",
                "currency": "USD"
            },
            {
                "amount": "23.45",
                "status": "0",
                "created_on": "1418899009000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "CH0000000065",
                "transaction_id": "MT0000000234",
                "currency": "USD"
            },
            {
                "amount": "150.00",
                "status": "0",
                "created_on": "1418899009000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000163",
                "transaction_id": "MT0000000236",
                "currency": "USD"
            },
            {
                "amount": "23.45",
                "status": "0",
                "created_on": "1418898831000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "CH0000000065",
                "transaction_id": "MT0000000233",
                "currency": "USD"
            },
            {
                "amount": "30.56",
                "status": "0",
                "created_on": "1418891536000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "CH0000000586",
                "transaction_id": "MT0000000217",
                "currency": "USD"
            },
            {
                "amount": "123.78",
                "status": "0",
                "created_on": "1418887936000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "Latte, coffee",
                "transaction_id": "MT0000000223",
                "currency": "USD"
            },
            {
                "amount": "33.00",
                "status": "0",
                "created_on": "1418887936000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "",
                "transaction_id": "MT0000000221",
                "currency": "USD"
            },
            {
                "amount": "76.91",
                "status": "0",
                "created_on": "1418884336000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000010",
                "notes": "",
                "transaction_id": "MT0000000227",
                "currency": "USD"
            },
            {
                "amount": "89.60",
                "status": "0",
                "created_on": "1418884336000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000156",
                "notes": "Dinner Buffet",
                "transaction_id": "MT0000000225",
                "currency": "USD"
            },
            {
                "amount": "123.09",
                "status": "0",
                "created_on": "1418880736000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "Sci-fi fictions",
                "transaction_id": "MT0000000231",
                "currency": "USD"
            },
            {
                "amount": "30.56",
                "status": "0",
                "created_on": "1418109245000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "KFC Family Meal",
                "transaction_id": "MT0000000039",
                "currency": "USD"
            },
            {
                "amount": "24.75",
                "status": "0",
                "created_on": "1418022845000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "Breakfast",
                "transaction_id": "MT0000000036",
                "currency": "USD"
            },
            {
                "amount": "35.89",
                "status": "0",
                "created_on": "1417850045000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000134",
                "notes": "KFC Kid Meal",
                "transaction_id": "MT0000000032",
                "currency": "USD"
            },
            {
                "amount": "23.45",
                "status": "SURVEY",
                "created_on": "1417763645000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000011",
                "notes": "Used textbooks",
                "transaction_id": "MT0000000030",
                "currency": "USD"
            },
            {
                "amount": "33.00",
                "status": "0",
                "created_on": "1417536000000",
                "user_id": "UR0000000001",
                "merchant_id": "MC0000000057",
                "notes": "cappuccino holiday mint",
                "transaction_id": "MT0000000090",
                "currency": "USD"
            }
        ],
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
fail message:<br/>
```json
{
    "code": "500",
    "message": "transaction_id,phone and email must be not all null.",
    "result": null
}
```
```json
{
    "code": "1132",
    "message": "[USER] The user is not available.",
    "result": {
        "total_count": ""
    }
}
```
```json
{
    "code": "1134",
    "message": "[MERCHANT] The merchant  is not available.",
    "result": {
        "total_count": ""
    }
}
```
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName:get_disputes
description: 获取dispute，并且没有finish的列表。<br/>
apiUrl: ${host}/user_api/v1/support/get_disputes<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "page_no": "1",
    "limit": "20",
    "rep_id": "pier.com",
    "session_token":"d5446baf-a831-11e4-8564-77a7e16f885e"
}
```

response: <==<br/>
success message:<br/>
search by transaction id:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "amount": "23.45",
                "status": "SURVEY",
                "created_on": "1422596212000",
                "entered_by": "pier.com",
                "user_id": "UR0000000001",
                "last_updated": "1422597700000",
                "merchant_id": "MC0000000011",
                "transaction_id": "MT0000000030",
                "dispute_id": "DS0000010130",
                "currency": "USD"
            }
        ],
        "total_count": "1",
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {}
}
```

### apiName:search_disputes_customer_rep
description: 搜索用戶dispute列表。<br/>
apiUrl: ${host}/user_api/v1/support/search_disputes_customer_rep<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "transaction_id": "MT0000000030",[可空，与phone,email不能同时为空]
    "phone": "18638998588",[可空，与transaction_id,email不能同时为空]
    "email":"hujun.qu@whatever.com"，[可空，与transaction_id,phone不能同时为空]
    "country_code": "CN",
    "page_no": "1",
    "limit": "20",
    "start_date":"2014-11-29",
    "end_date":"2015-01-30"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "amount": "23.45",
                "status": "SURVEY",
                "created_on": "1422596212000",
                "entered_by": "pier.com",
                "user_id": "UR0000000001",
                "last_updated": "1422597700000",
                "merchant_id": "MC0000000011",
                "transaction_id": "MT0000000030",
                "dispute_id": "DS0000010130",
                "currency": "USD"
            }
        ],
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
search by user phone:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "amount": "23.45",
                "status": "SURVEY",
                "created_on": "1422596212000",
                "entered_by": "pier.com",
                "user_id": "UR0000000001",
                "last_updated": "1422597700000",
                "merchant_id": "MC0000000011",
                "transaction_id": "MT0000000030",
                "dispute_id": "DS0000010130",
                "currency": "USD"
            }
        ],
        "total_count": "1",
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
search by merchant email:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "amount": "23.45",
                "status": "SURVEY",
                "created_on": "1422596212000",
                "entered_by": "pier.com",
                "user_id": "UR0000000001",
                "last_updated": "1422597700000",
                "merchant_id": "MC0000000011",
                "transaction_id": "MT0000000030",
                "dispute_id": "DS0000010130",
                "currency": "USD"
            }
        ],
        "total_count": "1",
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```
fail message:<br/>
```json
{
    "code": "500",
    "message": "transaction_id,phone and email must be not all null.",
    "result": null
}
```
```json
{
    "code": "1132",
    "message": "[USER] The user is not available.",
    "result": {
        "total_count": ""
    }
}
```
```json
{
    "code": "1134",
    "message": "[MERCHANT] The merchant  is not available.",
    "result": {
        "total_count": ""
    }
}
```
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

### apiName:get_dispute_handler_log
description: 获取具体dispute的处理日志。<br/>
apiUrl: ${host}/user_api/v1/support/get_dispute_handler_log<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "dispute_support_id": "DS0000010120"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "status": "INITIAL",
                "created_on": "1422596212000",
                "comments": "dispute",
                "processed_by": "pier.com",
                "dispute_id": "DS0000010130"
            },
            {
                "status": "SURVEY",
                "created_on": "1422597700000",
                "comments": "survey",
                "processed_by": "pier.com",
                "dispute_id": "DS0000010130"
            }
        ],
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e"
    }
}
```

### apiName:get_user_dispute_detail
description: 获取用戶相关信息，以及与其相关的dispute历史信息。<br/>
apiUrl: ${host}/user_api/v1/support/get_user_dispute_detail<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "user_id": "UR0000000001",
    "rep_id": "pier.com",
    "session_token":"d5446baf-a831-11e4-8564-77a7e16f885e",
    "start_date":"2015-01-01",
    "end_date":"2015-01-31"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "disputes": [
            {
                "amount": "23.45",
                "status": "SURVEY",
                "created_on": "1422596212000",
                "last_updated": "1422597700000",
                "merchant_id": "MC0000000011",
                "transaction_id": "MT0000000030",
                "currency": "USD"
            }
        ],
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e",
        "profile": [
            {
                "first_name": "ma",
                "phone": "18638998588",
                "primary_email": "zy@qq.com",
                "last_name": "zeyan",
                "country_code": "CN"
            }
        ]
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

### apiName:get_merchant_dispute_detail
description: 获取商家相关信息，以及与其相关的dispute历史信息。<br/>
apiUrl: ${host}/user_api/v1/support/get_merchant_dispute_detail<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
    "merchant_id": "MC0000000011",
    "rep_id": "pier.com",
    "session_token":"d5446baf-a831-11e4-8564-77a7e16f885e",
    "start_date":"2015-01-01",
    "end_date":"2015-01-31"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "disputes": [
            {
                "amount": "23.45",
                "status": "SURVEY",
                "created_on": "1422596212000",
                "user_id": "UR0000000001",
                "last_updated": "1422597700000",
                "transaction_id": "MT0000000030",
                "currency": "USD"
            }
        ],
        "session_token": "d5446baf-a831-11e4-8564-77a7e16f885e",
        "profile": [
            {
                "business_name": "Amazon",
                "phone": "2343234321",
                "email": "hujun.qu@whatever.com",
                "web_site": "asdfdf",
                "country_code": "US"
            }
        ]
    }
}
```

fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

# MERCHANT API 1
## MERCHANT QUERY API 1

### apiName: get_merchant_business_types
description: 获取商家公司类型。<br/>
apiUrl: ${host}/merchant_api/v1/query/get_bank_account_types<br/>
method: GET<br/>

request: ==><br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "1",
                "description": "CORPORATION",
                "is_default": "0"
            },
            {
                "id": "2",
                "description": "Individual/Sole Proprietorship",
                "is_default": "1"
            },
            {
                "id": "3",
                "description": "Non-Profit",
                "is_default": "0"
            },
            {
                "id": "4",
                "description": "Partnership",
                "is_default": "0"
            },
            {
                "id": "5",
                "description": "LLC",
                "is_default": "0"
            }
        ]
    }
}
```

若没有数据，则返回<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": null
}
```


### apiName: get_merchant_biz_category
description: 获取商家经营的行业分类。<br/>
apiUrl: ${host}/merchant_api/v1/query/get_merchant_biz_category<br/>
method: GET<br/>

request: ==><br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "1",
                "description": "Arts & Entertainment"
            },
            {
                "id": "2",
                "description": "Automotive"
            },
            {
                "id": "3",
                "description": "Business & Professional Services"
            },
            {
                "id": "4",
                "description": "Clothing & Accessories"
            },
            {
                "id": "5",
                "description": "Community & Government"
            },
            {
                "id": "6",
                "description": "Computers & Electronics"
            },
            {
                "id": "8",
                "description": "Education"
            },
            {
                "id": "9",
                "description": "Food & Dining"
            },
            {
                "id": "10",
                "description": "Health & Medicine"
            },
            {
                "id": "11",
                "description": "Home & Garden"
            },
            {
                "id": "12",
                "description": "Industry & Agriculture"
            },
            {
                "id": "14",
                "description": "Media & Communications"
            },
            {
                "id": "15",
                "description": "Personal Care & Services"
            },
            {
                "id": "16",
                "description": "Real Estate"
            },
            {
                "id": "17",
                "description": "Shopping"
            },
            {
                "id": "18",
                "description": "Sports & Recreation"
            },
            {
                "id": "19",
                "description": "Travel & Transportation"
            },
            {
                "id": "33",
                "description": "Movie"
            }
        ]
    }
}
```

若没有数据，则返回<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": null
}
```

### apiName: get_merchant_biz_subcategory
description: 获取商家经营的行业二级分类。<br/>
apiUrl: ${host}/merchant_api/v1/query/get_merchant_biz_subcategory<br/>
method: GET<br/>

request: ==><br/>
catid: 17 ; business category parent id, eg Shopping, 17.<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "20",
                "description": "Antiques & Collectibles"
            },
            {
                "id": "21",
                "description": "Baby Products & Services"
            },
            {
                "id": "22",
                "description": "Books, Magazines, & Publications"
            },
            {
                "id": "23",
                "description": "Clothing & Accessories"
            },
            {
                "id": "24",
                "description": "Discount & Used Goods"
            },
            {
                "id": "25",
                "description": "Flowers"
            },
            {
                "id": "26",
                "description": "Gifts & Novelties"
            },
            {
                "id": "27",
                "description": "Hobbies & Crafts"
            },
            {
                "id": "29",
                "description": "Home & Garden"
            },
            {
                "id": "30",
                "description": "Jewelers"
            },
            {
                "id": "31",
                "description": "Online & Catalog Shopping"
            },
            {
                "id": "32",
                "description": "Toys & Games"
            }
        ]
    }
}
```

failure message: <br/>
```json
{
    "code": "400",
    "message": "parameter catid is missing.",
    "result": null
}
```

### apiName: get_merchant_avg_payment_types
description: 获取商家每月平均流水范围。<br/>
apiUrl: ${host}/merchant_api/v1/query/get_merchant_avg_payment_types<br/>
method: GET<br/>

request: ==><br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "1",
                "description": "$0-$10",
                "is_default": "0"
            },
            {
                "id": "2",
                "description": "$10-$100",
                "is_default": "1"
            },
            {
                "id": "3",
                "description": "$100-$1000",
                "is_default": "0"
            },
            {
                "id": "4",
                "description": "$1000+",
                "is_default": "0"
            }
        ]
    }
}
```

若没有数据，则返回<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": null
}
```


### apiName: get_merchant_status
description: 获取商家当前的状态。若成功则返回商家id和status_bit。<br/>
<ul>status_bit 说明：
<li>4  开始注册merchant,完成步骤register_merchant_1，待进行步骤register_merchant_2;</li>
<li>5  完成merchant_register_2,待进行邮件验证;</li>
<li>13 邮件验证成功，可以进行dashboard里的功能使用了；</li>
</ul>
apiUrl: ${host}/merchant_api/v1/query/get_merchant_status<br/>
method: GET<br/>

request: ==><br/>
email: test@pierup.com ;注册的商家邮箱帐号<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "MC0000000518",
                "status_bit": "13"
            }
        ]
    }
}
```

若没有该邮箱对应的商家帐号，返回：<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```

failure message: <br/>
http_code: 400 <br/>
```json
{
    "code": "400",
    "message": "parameter email is missing.",
    "result": null
}
```

### apiName: get_merchants
description: 获取商家信息列表。<br/>
apiUrl: ${host}/merchant_api/v1/query/get_merchants<br/>
method: GET<br/>

request: ==><br/>
business_name: Pierup； 商家名称<br/>
page_no: 1 ; 分页显示的页号<br/>
limit: 10 ； 每页显示的条数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg3@2x.jpg",
                "phone": "5103379974",
                "business_type_id": "1",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg3@2x.jpg",
                "created_on": "1416991460000",
                "biz_addr_id": "",
                "business_summary": "Simple Credit For Living a Better Life",
                "country_code": "US",
                "business_name": "Team Pier",
                "logo_big_url": "http://user-api.elasticbeanstalk.com/images/shop_logo2@2x.png",
                "itunes_url": "",
                "scheme": "",
                "email": "hr1@pierup.com",
                "status_bit": "13",
                "sub_category_id": "120",
                "merchant_id": "AAA000000001",
                "web_site": "pierup.com",
                "logo_small_url": "http://user-api.elasticbeanstalk.com/images/shop_logo2@2x.png"
            },
            {
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg3@2x.jpg",
                "phone": "2343543456",
                "business_type_id": "3",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg3@2x.jpg",
                "created_on": "1418134364000",
                "biz_addr_id": "",
                "business_summary": "asdfvsdf",
                "country_code": "US",
                "business_name": "Pier Inc",
                "logo_big_url": "http://user-api.elasticbeanstalk.com/images/shop_logo2@2x.png",
                "itunes_url": "",
                "scheme": "",
                "email": "hujun.qu@pier.com",
                "status_bit": "13",
                "sub_category_id": "120",
                "merchant_id": "MC0000000010",
                "web_site": "sdfsdf",
                "logo_small_url": "http://user-api.elasticbeanstalk.com/images/shop_logo2@2x.png"
            },
            {
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg3@2x.jpg",
                "phone": "2343234321",
                "business_type_id": "5",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg3@2x.jpg",
                "created_on": "1418134672000",
                "biz_addr_id": "",
                "business_summary": "asdfsdf",
                "country_code": "US",
                "business_name": "Amazon",
                "logo_big_url": "http://user-api.elasticbeanstalk.com/images/shop_logo2@2x.png",
                "itunes_url": "",
                "scheme": "",
                "email": "hujun.qu@whatever.com",
                "status_bit": "13",
                "sub_category_id": "120",
                "merchant_id": "MC0000000011",
                "web_site": "asdfdf",
                "logo_small_url": "http://user-api.elasticbeanstalk.com/images/shop_logo2@2x.png"
            },
            {
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "phone": "1988892929",
                "business_type_id": "5",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "created_on": "1417484047000",
                "biz_addr_id": "",
                "business_summary": "Pierup%3A+a+virtual+credit+card+corporation.",
                "country_code": "US",
                "business_name": "Pier",
                "logo_big_url": "http://photo.pierup.com.s3.amazonaws.com/pier_merchant/logo/big/MC0000000017.png?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1737287897&Signature=pZ5yGot4LlDw9YnO4MBTKN1h7zE%3D",
                "itunes_url": "",
                "scheme": "",
                "email": "adorechen@163.com_bak",
                "status_bit": "13",
                "sub_category_id": "120",
                "merchant_id": "MC0000000017",
                "web_site": "http%3A%2F%2Fwww.pierup.com%2F",
                "logo_small_url": "http://photo.pierup.com.s3.amazonaws.com/pier_merchant/logo/small/MC0000000017.png?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1737287899&Signature=NI%2F8rTCApwtaW9inTOFsxqa%2B4gc%3D"
            },
            {
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "phone": "1234567890",
                "business_type_id": "2",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "created_on": "1418201801000",
                "biz_addr_id": "",
                "business_summary": "hello world",
                "country_code": "US",
                "business_name": "Starbucks",
                "logo_big_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png",
                "itunes_url": "",
                "scheme": "",
                "email": "richardxin169@yahoo.com",
                "status_bit": "13",
                "sub_category_id": "120",
                "merchant_id": "MC0000000057",
                "web_site": "pierup.com",
                "logo_small_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png"
            },
            {
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "phone": "1324826909",
                "business_type_id": "1",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "created_on": "1418204691000",
                "biz_addr_id": "",
                "business_summary": "We sell nothing!",
                "country_code": "US",
                "business_name": "Uiwi",
                "logo_big_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png",
                "itunes_url": "",
                "scheme": "",
                "email": "570367811@qq.com",
                "status_bit": "5",
                "sub_category_id": "19",
                "merchant_id": "MC0000000064",
                "web_site": "www.uiwi.com",
                "logo_small_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png"
            },
            {
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "phone": "2343243200",
                "business_type_id": "4",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "created_on": "1418237015000",
                "biz_addr_id": "",
                "business_summary": "test2",
                "country_code": "US",
                "business_name": "test3",
                "logo_big_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png",
                "itunes_url": "",
                "scheme": "",
                "email": "test2@example.com",
                "status_bit": "5",
                "sub_category_id": "5",
                "merchant_id": "MC0000000083",
                "web_site": "test2.com",
                "logo_small_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png"
            }
        ],
        "total_count": "84"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter business_name is missing.",
    "result": null
}
```


### apiName: get_merchants_first_page
description: 获取商家信息列表。<br/>
apiUrl: ${host}/merchant_api/v1/query/get_merchants_first_page<br/>
method: GET<br/>

request: ==><br/>

dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "product_small_url": "http://192.168.1.96:8090/merchant_api/images/shop_bg1@2x.jpg",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1414534107000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "rr@pierup.com",
                "status_bit": "13",
                "merchant_id": "MC0000000265",
                "web_site": "http://www.amazon.com/",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4561",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1414538610000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "rr5@pierup.com",
                "status_bit": "5",
                "merchant_id": "MC0000000266",
                "web_site": "http://www.amazon.com/",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4511",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1414980446000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "rr18@pierup.com",
                "status_bit": "5",
                "merchant_id": "MC0000000279",
                "web_site": "http://www.amazon.com/",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416990137000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "T2@PIERUP.COM",
                "status_bit": "13",
                "merchant_id": "MC0000000692",
                "web_site": "MYWEBSITE.COM",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416991237000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "T3@PIERUP.COM",
                "status_bit": "13",
                "merchant_id": "MC0000000693",
                "web_site": "MYWEBSITE.COM",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416991455000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "T4@PIERUP.COM",
                "status_bit": "13",
                "merchant_id": "MC0000000695",
                "web_site": "MYWEBSITE.COM",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416991456000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "T5@PIERUP.COM",
                "status_bit": "13",
                "merchant_id": "MC0000000696",
                "web_site": "MYWEBSITE.COM",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416991456000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "T6@PIERUP.COM",
                "status_bit": "13",
                "merchant_id": "MC0000000697",
                "web_site": "MYWEBSITE.COM",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416991456000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "T7@PIERUP.COM",
                "status_bit": "13",
                "merchant_id": "MC0000000698",
                "web_site": "MYWEBSITE.COM",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            },
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "626-123-4567",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416991456000",
                "biz_addr_id": "",
                "business_summary": "test",
                "country_code": "US",
                "business_category_id": "17",
                "business_name": "Pierup",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "T8@PIERUP.COM",
                "status_bit": "13",
                "merchant_id": "MC0000000699",
                "web_site": "MYWEBSITE.COM",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            }
        ],
        "total_count": "47"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter business_name is missing.",
    "result": null
}
```

## MERCHANT REGISTER API 1

### register_merchant_1
apiName: register_merchant_1<br/>
description: 商家注册第一步，输入邮箱和密码，注册商家帐号。<br/>
<ul>status_bit 说明：
<li>4  开始注册merchant,完成步骤register_merchant_1，待进行步骤register_merchant_2;</li>
<li>5  完成merchant_register_2,待进行邮件验证;</li>
<li>13 邮件验证成功，可以进行dashboard里的功能使用了；</li>
</ul>
apiUrl:  ${host}/merchant_api/v1/register/register_merchant_1<br/>
method: POST<br/>


request:  <br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求内容<br/>

```json
{
    "email":"test@pierup.com",
    "password":"123456"
}
```

response:  <br/>
success message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "status_bit": "4",
                "merchant_id": "MC0000000017",
                "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
            }
        ]
    }
}
```

failure message:<br/>
若email已经注册过了。<br/>
http_code: 400
```json
{
    "code": "1065",
    "message": "[MERCHANT] merchant w same email already registered",
    "result": {}
}
```

若没有输入参数email,password:<br/>
```json
{
    "code": "400",
    "message": "Invalid email: null",
    "result": null
}
```

### register_merchant_2
apiName: register_merchant_2<br/>
description: 商家在完成第一步邮箱用户注册之后，可以进行第二部商家用户信息注册，填写商家相关信息。 <br/>
<ul>status_bit 说明：
<li>4  开始注册merchant,完成步骤register_merchant_1，待进行步骤register_merchant_2;</li>
<li>5  完成merchant_register_2,待进行邮件验证;</li>
<li>13 邮件验证成功，可以进行dashboard里的功能使用了；</li>
</ul>
apiUrl:   /merchant_api/v1/register/register_merchant_2<br/>
method: POST<br/>

request:  <br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求内容<br/>

```json
{
    "merchant_id": "MC0000000017",
    "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
    "tax_id": "111111119",
    "country_code": "US",
    "business_name": "Pier",
    "phone": "1988892929",
    "business_type_id": "1",
    "web_site": "http%3A%2F%2Fwww.pierup.com%2F",
    "category_id": "1",
    "avg_payment_id": "2",
    "business_summary": "Pierup%3A+a+virtual+credit+card+corporation."
}
```


说明：<br/>
merchant_id 和 session_token 由商家注册第一步获取得到；<br/>
tax_id： 美国税号 9位<br/>
country_code:  由查询接口 get_countries 获取得到。<br/>
business_type_id:  由查询接口 get_merchant_business_types 获取得到。<br/>
category_id:  由查询接口 get_merchant_biz_category和 get_merchant_biz_subcategory获取得到。<br/>
avg_payment_id:  由查询接口 get_merchant_avg_payment_types获取得到。<br/>
business_summary:  长度不超过256；<br/>
phone:  根据country_code 来决定电话号码长度，美国10位，中国11位；<br/>

response: <br/>
success message:<br/>
http_code: 200
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "email": "test@pierup.com",
        "status_bit": "5",
        "merchant_id": "MC0000000017",
        "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
    }
}
```

failure message:
服务器内部错误<br/>
http_code: 500<br/>
```json
{
    "code": "500",
    "message": "Duplicate entry '111111116' for key 'IX_MERCHANT_TAX_ID'",
    "result": null
}
```

参数未输入完全；<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter merchant_id is missing.",
    "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

### apiName: email_verification<br/>
description: 商户通过有点击的邮箱里的验证链接时调用的api, 验证通过后提醒用户登录。<br/>

apiUrl: ${host}/merchant_api/v1/register/email_verification <br/>
method: POST<br/>

request:<br/>
以下参数为URL query参数：<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

以下为JSON格式的请求数据：
```json
{
    "verification_token": "5b053f72a9e9-e7a9-4e11-3e06-956fba53"
}
```

response:  <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "merchant_id": "MC0000000017"
    }
}
```

failure message:<br/>
输入参数不全：<br/>
```json
{
    "code": "400",
    "message": "parameter verification_token is missing.",
    "result": null
}
```

verification_token过期：<br/>
http_code: 400<br/>
```json
{
    "code": "1102",
    "message": "[Merchant] mail verification token is expired, period of validity is 7 days.",
    "result": {}
}
```

verification is error:<br/>
http_code: 400<br/>
```json
{
    "code": "1094",
    "message": "[Merchant] mail verification token is invalid.",
    "result": {}
}
```


### apiName: resend_verification<br/>
description: 商户没有收到验证邮件时，可以手动点击重发校验邮件时调用的api；<br/>

apiUrl: ${host}/merchant_api/v1/register/resend_verification<br/>
method: POST<br/>

request:<br/>
以下参数为URL query参数：<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

以下为JSON格式的请求数据：
```json
{
    "merchant_id": "MC0000000275",
    "session_token": "ad6f5cb6-6343-11e4-9a7e-9e9a27f350b5"
}
```
required:<br/>
all; <br/>

response:  <==<br/>
success message:
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "email": "test@pierup.com"
            }
        ],
        "session_token": "aaf74c23-8105-11e4-8328-32913f86e6ed"
    }
}
```

failure message:<br/>

输入参数不全：<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter merchant_id is missing.",
    "result": null
}
```

### apiName: forget_password<br/>
description: 商户忘记密码时，发送重设密码的api；<br/>

apiUrl: ${host}/merchant_api/v1/register/forget_password<br/>
method: POST<br/>

request:<br/>
以下参数为URL query参数：<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

以下为JSON格式的请求数据：
```json
{
    "email": "test@pierup.com"
}
```
required:<br/>
all; <br/>

response:  <==<br/>
success message:
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "email": "test@pierup.com",
        "expiration": "1800",
        "token_id": "1"
    }
}
```

failure message:<br/>

输入参数不全：<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter email is missing.",
    "result": null
}
```

邮件已经发送并在有效期：<br/>
http_code: 400<br/>
```json
{
    "code": "1118",
    "message": "[Email] email has sent and the url are in valid period. ",
    "result": {}
}
```

### apiName: set_password<br/>
description: 商户忘记密码时希望重设密码的api；<br/>

apiUrl: ${host}/merchant_api/v1/register/set_password<br/>
method: POST<br/>

request:<br/>
以下参数为URL query参数：<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

以下为JSON格式的请求数据：
```json
{
    "token": "500d9fcbedff313584be005b4daeb5c7",
    "password": "123456"
}
```
required:<br/>
all; <br/>

response:  <==<br/>
success message:
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "user_merchant_id": "MC0000000089"
    }
}
```

failure message:<br/>

输入参数不全：<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter token is missing.",
    "result": null
}
```

token已经使用过了：<br/>
http_code: 400<br/>
```json
{
    "code": "1113",
    "message": "[TOKEN] Token has used.",
    "result": {
        "user_merchant_id": ""
    }
}
```

## MERCHANT MANGE API 1

### apiName: merchant_signin
description: 商家登录,登录以后返回status_bit根据状态数字跳转到相应步骤。只有当status_bit状态为13之后才能访问dashboard里的其他功能。<br/>
<ul>status_bit 说明：
<li>4  开始注册merchant,完成步骤register_merchant_1，待进行步骤register_merchant_2;</li>
<li>5  完成merchant_register_2,待进行邮件验证;</li>
<li>13 邮件验证成功，可以进行dashboard里的功能使用了；</li>
</ul>

apiUrl: ${host}/merchant_api/v1/manage/merchant_signin<br/>
method: POST<br/>

request:<br/>
以下参数为URL query参数：<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

以下为JSON格式的请求数据：
```json
{
    "email": "test@pierup.com",
    "password": "abc123"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "status_bit": "13",
                "merchant_id": "MC0000000017",
                "session_token": "1aafa9db-7a0f-11e4-a108-b3b264dd2935"
            }
        ]
    }
}
```
fail message:<br/>
登录失败<br/>
http_code: 401<br/>
```json
{
    "code": "1095",
    "message": "[Security] login failed, email or password uncorrect.",
    "result": {}
}
```


### apiName: merchant_signout
description: 商家退出<br/>
apiUrl: ${host}/merchant_api/v1/manage/merchant_signout<br/>
method: POST<br/>

request:<br/>
以下参数为URL query参数：<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

以下为JSON格式的请求数据：
```json
{
    "merchant_id": "MC0000000273",
    "session_token": "35fef03c-6017-11e4-b4fe-22000a1ca299"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}
```

failure message:<br/>
输入参数不全：<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter session_token is missing.",
    "result": null
}
```


### apiName: profile_get
description: 获取商家相关信息。<br/>
apiUrl: ${host}/merchant_api/v1/manage/profile_get<br/>
method: POST<br/>

query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

<b>request</b>: ==><br/>
```json
{
	"merchant_id": "MC0000000518",
	"session_token": "fd277add-6fbf-11e4-b50d-f181b1f2ab81"
}
```

response: <==<br/>
success message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "tax_id_src": "111111125",
                "product_small_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "phone": "1988892929",
                "business_type_id": "1",
                "product_big_url": "http://user-api.elasticbeanstalk.com/images/shop_bg1@2x.jpg",
                "created_on": "1417484047000",
                "biz_addr_id": "",
                "business_summary": "Pierup%3A+a+virtual+credit+card+corporation.",
                "category_id": "4",
                "country_code": "US",
                "avg_payment_id": "2",
                "business_name": "Pier",
                "logo_big_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png",
                "email": "adorechen@163.com",
                "status_bit": "13",
                "sub_category_id": "35",
                "tax_id": "*****1125",
                "merchant_id": "MC0000000017",
                "web_site": "http%3A%2F%2Fwww.pierup.com%2F",
                "logo_small_url": "http://user-api.elasticbeanstalk.com/images/shop_logo1@2x.png"
            }
        ],
        "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
    }
}
```



failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter merchant_id is missing.",
    "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

### apiName: profile_update
description: 更新商家相关信息。<br/>
apiUrl: ${host}/merchant_api/v1/manage/profile_update<br/>
method: PUT<br/>

request: ==><br/>
url query parameter as follows:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

JSON request parameters as follows: <br/>
```json
{
    "merchant_id": "MC0000000017",
    "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
    "tax_id": "111111116",
    "country_code": "US",
    "business_name": "Pier",
    "phone": "1988892929",
    "business_type_id": "1",
    "web_site": "http%3A%2F%2Fwww.pierup.com%2F",
    "category_id": "1",
    "avg_payment_id": "2",
    "business_summary": "Pierup%3A+a+virtual+credit+card+corporation.",
    "email": "test@pierup.com"
}
```

说明：<br/>
required parameters: <br/>
merchant_id, session_token; <br/>
            

response: <==<br/>
success message:<br/>
http_code: 200<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "product_small_url": "http://localhost:8080/merchant_api/images/product_small.png",
                "phone": "1988892929",
                "business_type_id": "1",
                "product_big_url": "http://localhost:8080/merchant_api/images/product_big.png",
                "created_on": "1416305639000",
                "biz_addr_id": "",
                "business_summary": "Amazon: retail store.",
                "business_category_id": "1",
                "country_code": "US",
                "avg_payment_id": "2",
                "business_name": "amazon.com",
                "logo_big_url": "http://localhost:8080/merchant_api/images/logo_big.png",
                "email": "test@pierup.com",
                "status_bit": "13",
                "tax_id": "111111116",
                "merchant_id": "MC0000000518",
                "web_site": "http://www.amazon.com/",
                "logo_small_url": "http://localhost:8080/merchant_api/images/logo_small.png"
            }
        ],
        "session_token": "fd277add-6fbf-11e4-b50d-f181b1f2ab81"
    }
}
```



failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter merchant_id is missing.",
    "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

### apiName: key_get
description: 获取商家的所有KEY。<br/>
apiUrl: ${host}/merchant_api/v1/manage/key_get<br/>
method: POST<br/>

query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

<b>request</b>: ==><br/>
```json
{
	"merchant_id": "MC0000000518",
	"session_token": "fd277add-6fbf-11e4-b50d-f181b1f2ab81"
}
```

response: <==<br/>
success message:<br/>
http_code: 200
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "12",
                "api_id": "1e99006e-79ce-11e4-a108-b3b264dd2935",
                "api_secret_key": "mk-test-1e99002c-79ce-11e4-a108-b3b264dd2935",
                "key_name": "default_test",
                "created_on": "1417488691000",
                "is_production": "0",
                "descriptions": "test key generated by register_2"
            },
            {
                "id": "13",
                "api_id": "4f2c1033-79cf-11e4-a108-b3b264dd2935",
                "api_secret_key": "mk-test-4f2c0feb-79cf-11e4-a108-b3b264dd2935",
                "key_name": "default_test",
                "created_on": "1417489202000",
                "is_production": "0",
                "descriptions": "test key generated by register_2"
            },
            {
                "id": "14",
                "api_id": "ccb0bbb4-79cf-11e4-a108-b3b264dd2935",
                "api_secret_key": "mk-test-ccb0bb6f-79cf-11e4-a108-b3b264dd2935",
                "key_name": "default_test",
                "created_on": "1417489412000",
                "is_production": "0",
                "descriptions": "test key generated by register_2"
            }
        ],
        "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter merchant_id is missing.",
    "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```


### apiName: key_add
description: 创建商家的KEY。<br/>
apiUrl: ${host}/merchant_api/v1/manage/key_add<br/>
method: POST<br/>

request: ==><br/>

query parameters:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameters: <br/>
```json
{
    "merchant_id": "MC0000000017",
    "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
    "type": "produce",
    "key_name": "pier credit store",
    "description": "pier credit store online"
}
```    

required parameters:<br/>
merchant_id, session_token, type, key_name;<br/>

note:<br/>
type: 取值范围 [test, prod] <br/>

response: <==<br/>
success message:<br/>
http_code: 200
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "c03004ec-a1f8-11e4-8564-77a7e16f885e"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter key_name is missing.",
    "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

### apiName: key_delete
description: 创建商家的KEY。<br/>
apiUrl: ${host}/merchant_api/v1/manage/key_delete<br/>
method: POST<br/>

request: ==><br/>

query parameters:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameters: <br/>
```json
{
    "merchant_id": "MC0000004485",
    "session_token": "c03004ec-a1f8-11e4-8564-77a7e16f885e",
    "key_id": "98"
}
```    

response: <==<br/>
success message:<br/>
http_code: 200
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "session_token": "c03004ec-a1f8-11e4-8564-77a7e16f885e"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
    "code": "400",
    "message": "parameter key_id is missing.",
    "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": ""
    }
}
```

### apiName: bank_account_get 
description: 获取商家的银行帐号。<br/>
apiUrl:
${host}/merchant_api/v1/manage/bank_account_get<br/>
method: POST<br/>

query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


<b>request</b>: ==><br/>
```json
{
	"merchant_id": "MC0000000518",
	"session_token": "fd277add-6fbf-11e4-b50d-f181b1f2ab81"
}
```

<b>response</b>: <==<br/>
success message:<br/>
http_code: 200
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "bank_id": "BI9000000259",
                "id": "BK0000010940",
                "bank_name": "State Street Bank And Trust Company",
                "account_number": "********2342",
                "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/BI9000000259.png",
                "verified": "0",
                "is_primary": "1",
                "merchant_id": "MC0000000134",
                "type_id": "1"
            },
            {
                "bank_id": "BI9000000259",
                "id": "BK0000010937",
                "bank_name": "State Street Bank And Trust Company",
                "account_number": "*****5644",
                "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/BI9000000259.png",
                "verified": "0",
                "is_primary": "0",
                "merchant_id": "MC0000000134",
                "type_id": "2"
            },
            {
                "bank_id": "BI9000006028",
                "id": "BK0000010958",
                "bank_name": "Bank Of China, New York",
                "account_number": "*******6465",
                "image_url": "",
                "verified": "0",
                "is_primary": "0",
                "merchant_id": "MC0000000134",
                "type_id": "1"
            },
            {
                "bank_id": "BI9000000259",
                "id": "BK0000010980",
                "bank_name": "State Street Bank And Trust Company",
                "account_number": "****6156",
                "image_url": "http://photo.pierup.com.s3.amazonaws.com/banklogos/BI9000000259.png",
                "verified": "1",
                "is_primary": "0",
                "merchant_id": "MC0000000134",
                "type_id": "1"
            }
        ],
        "session_token": "0fff77c9-c178-11e4-8564-77a7e16f885e"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: bank_account_add
description: 添加商家的银行帐号。<br/>
apiUrl: ${host}/merchant_api/v1/manage/bank_account_add<br/>
method: POST<br/>

<b>request</b>: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

JSON request parameter:<br/>
```json
{
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "bank_id": "BI9000000003",
     "account_no": "1234567890",
     "account_type_id": "2",
     "is_primary": "1"
}
```

required parameter:<br/>
all.<br/>

note:<br/>
bank_id: data from common api named get_bank_info;<br/>
account_no: length is not more than 24;<br/>
account_type_id: data from common api named get_bank_account_type;<br/>
is_primary: 0 not primary, 1 primary;<br/>

<b>response</b>: <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter bank_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

插入数据时发生错误:<br/>
http_code: 500<br/>
```json
{
     "code": "500",
     "message": "Data truncation: Data too long for column '_account_no'
at row 10",
     "result": null
}
```

### apiName: address_get
description: 获取商家的地址信息。<br/>
apiUrl: ${host}/merchant_api/v1/manage/address_get<br/>
method: POST<br/>


query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

<b>request:</b> ==><br/>
```json
{
	"merchant_id": "MC0000000518",
	"session_token": "fd277add-6fbf-11e4-b50d-f181b1f2ab81"
}
```


<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "items": [
             {
                 "state_province_code": "NY",
                 "id": "AD0000000035",
                 "postal_code": "1222",
                 "address": "test address ",
                 "is_primary": "1",
                 "country_code": "US",
                 "city": "New York"
             }
         ],
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: address_add 
description: 添加商家的地址信息。<br/>
apiUrl: ${host}/merchant_api/v1/manage/address_add<br/>
method: POST<br/>

<b>request:</b> ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

JSON request parameter:<br/>
```json
{
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "address": "test address ",
     "city": "New York",
     "state_code": "NY",
     "country_code": "US",
     "postal_code": "1222",
     "is_primary": "1"
}
```
required parameter:<br/>
merchant_id,
session_token,
address,
city,
state_code,
country_code,
postal_code,
is_primary
<br/>

note:<br/>
state_code: data from common api named get_state_and_province;<br/>
country_code: data from common api named get_countries;<br/>

<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "address_id": "AD0000000035",
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: address_update 
description: 更新商家的地址信息。<br/>
apiUrl: ${host}/merchant_api/v1/manage/address_update<br/>
method: PUT<br/>

<b>request:</b> ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

JSON request parameter:<br/>
```json
{
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "address_id": "AD0000000004",
     "address": "test address ",
     "city": "New York",
     "state_code": "NY",
     "country_code": "US",
     "postal_code": "1222",
     "is_primary": "1"
}
```
required parameter:<br/>
merchant_id,
session_token,
address_id,
address,
city,
state_code,
country_code,
postal_code,
is_primary
<br/>

note:<br/>
state_code: data from common api named get_state_and_province;<br/>
country_code: data from common api named get_countries;<br/>

<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "address_id": "AD0000000035",
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: address_deactive 
description: 禁用商家的地址信息。<br/>
apiUrl: ${host}/merchant_api/v1/manage/address_deactive<br/>
method: POST<br/>

<b>request:</b> ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

JSON request parameter:<br/>
```json
{
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "address_id": "AD0000000037"
}
```
required parameter:<br/>
merchant_id,
session_token,
address_id
<br/>

<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter address_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: primary_address_get
description: 获取商家的地址信息。<br/>
apiUrl: ${host}/merchant_api/v1/manage/primary_address_get<br/>
method: POST<br/>

query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

<b>request</b>: ==><br/>
```json
{
	"merchant_id": "MC0000000518",
	"session_token": "fd277add-6fbf-11e4-b50d-f181b1f2ab81"
}
```

<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "state_province_code": "AK",
                "id": "AD0000001781",
                "postal_code": "22222",
                "address_1": "22",
                "country_code": "US",
                "city": "www.flower.com"
            }
        ],
        "session_token": "368eaf37-93bd-11e4-aad2-0ea81fa3d43c"
    }
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: primary_address_set
description: 设置商家的地址信息为常用地址。<br/>
apiUrl: ${host}/merchant_api/v1/manage/primary_address_set<br/>
method: POST<br/>

<b>request:</b> ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

JSON request parameter:<br/>
```json
{
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "address_id": "AD0000000035"
}
```
required parameter:<br/>
merchant_id,
session_token,
address_id
<br/>

<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter address_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: merchant_logo POST
description: 上传商家的logo图片。<br/>
apiUrl: ${host}/merchant_api/v1/manage/merchant_logo<br/>
method: POST<br/>
Content-Type: multipart/form-data

<b>request:</b> ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

form request parameter:<br/>
"merchant_id": "MC0000000017", <br/>
"session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"<br/>
"file": FILE <br/>


required parameter:<br/>
merchant_id,
session_token,
file
<br/>

<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "logoUrl":
"https://photo.pierup.com.s3.amazonaws.com/pier_user/MC0000000017_logo_big.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1419430904&Signature=a9%2Bgk%2FHDX8U2f%2FMIF8lqObqhNXY%3D",
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "no file uploaded.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```


### apiName: merchant_product POST
description: 上传商家的logo图片。<br/>
apiUrl: ${host}/merchant_api/v1/manage/merchant_product<br/>
method: POST<br/>
Content-Type: multipart/form-data

<b>request:</b> ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

form request parameter:<br/>
"merchant_id": "MC0000000017", <br/>
"session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"<br/>
"file": FILE <br/>


required parameter:<br/>
merchant_id,
session_token,
file
<br/>

<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "productUrl":
"https://photo.pierup.com.s3.amazonaws.com/pier_user/MC0000000017_prod_big.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1419431335&Signature=TIyZcTtcFqACYZojgKFLGLSdphg%3D",
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "no file uploaded.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: switch_mode 
description: 切换商家模式（test/live)。<br/>
apiUrl: ${host}/merchant_api/v1/manage/switch_mode<br/>
method: POST<br/>

<b>request:</b> ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

JSON request parameter:<br/>
```json
{
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "dest_mode": "test"
}
```
required parameter:<br/>
merchant_id,
session_token,
dest_mode
<br/>

noted:<br/>
dest_mode: 取值范围 test/live;<br/>


<b>response:</b> <==<br/>
success message:<br/>
http_code: 200
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter dest_mode is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

## Merchant Transaction API 1

### apiName: fee_plan_get
description: 获取商家交易收费规则信息。<br/>
apiUrl:
${host}/merchant_api/v1/transaction/fee_plan_get<br/>
method: POST<br/>

request parameter:<br/>
merchant_id: MC0000000017； 商家id<br/>
session_token: 51162fa9-79cb-11e4-a108-b3b264dd2935<br/>
from_date: 规则的开始日期 <br/>
end_date: 规则的结束日期 <br/>
active: 规则是否正在使用(0,1)<br/>,

dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

required parameter:<br/>
merchant_id,
session_token,
<br/>

request json:<br/>
```json
{
	"merchant_id": "MC0000000017",
	"session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
	"from_date": "2014-12-01",
	"end_date": "2015-01-01",
	"active": "1",
}
```


response: <==<br/>
success message:<br/>
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "items": [
             {
                 "id": "14",
                 "min_amt": "0.00",
                 "flat_fee": "0.29",
                 "max_amt": "10000.00",
                 "percentage": "2.50",
                 "created_on": "1416389895000",
                 "active": "1",
                 "to_date": "1419955200000",
                 "from_date": "1388505600000",
                 "merchant_id": "MC0000000518",
                 "currency": "USD",
                 "discount": "0.20"
             },
             {
                 "id": "15",
                 "min_amt": "",
                 "flat_fee": "0.01",
                 "max_amt": "",
                 "percentage": "2.10",
                 "created_on": "1416450132000",
                 "active": "1",
                 "to_date": "",
                 "from_date": "",
                 "merchant_id": "MC0000000518",
                 "currency": "USD",
                 "discount": "0.20"
             }
         ],
         "session_token": "fd277add-6fbf-11e4-b50d-f181b1f2ab81"
     }
}
```

没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: fee_plan_add
description: 增加商家的费用规则。仅针对admin权限的人员开放。<br/>
apiUrl: ${host}/merchant_api/v1/transaction/fee_plan_add<br/>
method: POST<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "from_date": "2014-01-01 00:00:00",
     "end_date": "2014-12-31 23:59:59",
     "min_amount": "0.00",
     "max_amount": "10000.00",
     "flat_fee": "0.29",
     "percentage": "2.5",
     "discount": "0.2",
     "active": "1",
     "currency": "USD"
}
```

required parameter:<br/>
merchant_id,
session_token,
percentage,
discount,
currency,
active,
<br/>

note:<br/>
merchant_id: 固定长度12位； 格式MC1234567890; <br/>
session_token： 固定长度36位； <br/>
flat_fee: 收取商家的固定费用，格式0.00；
percentage：商家收费%费率，去掉%之后的数字，取值范围 -100.00 ～
100.00;    <br/>
discount： 商家费用折扣率，去掉%之后的数字，取值范围0.00 ～ 100.00；   
  <br/>
currency： 币种，长度3位，大写字母，如USD；    <br/>
active： 是否激活标志位，0未激活，1激活;      <br/>


response: <br/>
sucess message:<br/>
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```

### apiName: fee_plan_update
description: 修改商家的收费规则，仅针对admin权限的人员开放。<br />
更新商家的收费规则，仅更新active状态时是修改原来的收费规则；<br/>
若是有改变收费规则的数据时则是禁用以前的收费规则，新建一条收费规则<br/>

apiUrl: ${host}/merchant_api/v1/transaction/fee_plan_update<br/>
method: PUT<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
     "id": "16",
     "merchant_id": "MC0000000017",
     "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935",
     "from_date": "2014-01-01 00:00:00",
     "end_date": "2014-12-31 23:59:59",
     "min_amount": "0.00",
     "max_amount": "10000.00",
     "flat_fee": "0.29",
     "percentage": "2.5",
     "discount": "0.2",
     "active": "1",
     "currency": "USD"
}
```

required parameter:<br/>
id, merchant_id, session_token <br/>

note:<br/>
id: 要更新的规则id； <br/>
merchant_id: 固定长度12位； 格式MC1234567890; <br/>
session_token： 固定长度36位； <br/>
flat_fee: 收取商家的固定费用，格式0.00；
percentage：商家收费%费率，去掉%之后的数字，取值范围 -100.00 ～
100.00;    <br/>
discount： 商家费用折扣率，去掉%之后的数字，取值范围0.00 ～ 100.00；   
  <br/>
currency： 币种，长度3位，大写字母，如USD；    <br/>
active： 是否激活标志位，0未激活，1激活;      <br/>


response: <br/>
sucess message:<br/>
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
     }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter id is missing.",
     "result": null
}
```

session_token过期或者session_token无效的错误：<br/>
http_code: 401<br/>
```json
{
     "code": "1001",
     "message": "[SECURITY_ERROR] Session token is invalid or expired",
     "result": {
         "session_token": ""
     }
}
```


### apiName: get_histories
description: 用户消费，充值或者还款历史查询。<br/>
apiUrl: ${host}/merchant_api/v1/transaction/get_histories<br/>
method: GET<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
     "merchant_user_id": "UR0000000001",[用户或者商家id]
     "query_id": "UR0000000001",[查询id，可以为用户id,商家id和具体的交易
或者还款充值记录id]
     "option": "0",[:操作码 0:交易历史和还款充值历史的并集|1:交易历史|2:
还款充值历史|3:具体交易，还款或者充值的流水历史]
     "start_date": "2014-11-10",[开始时间]
     "end_date": "2014-12-03",[结束时间]
     "page_no": "1",[页码]
     "limit": "10",[每页最大记录数 0-20]
     "session_token": "147da345-7957-11e4-a108-b3b264dd2935",[会话凭证]
     "device_token": "DE06521F-7E3C-4B4C-A031-8B4828A30697"[移动设备凭证]
}
```

response: <==<br/>
success message:<br/>
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "device_token": "DE06521F-7E3C-4B4C-A031-8B4828A30697",
         "items": [
             {
                 "amount": "100.00",
                 "id": "PY0000000025",
                 "history_type": "PAYMENT",
                 "to_id": "PierAccount",
                 "from_id": "UR0000000001",
                 "created_on": "1417487742000",
                 "last_updated": "1417487742000",
                 "notes": "还款",
                 "currency": "USD"
             }
         ],
         "session_token": "147da345-7957-11e4-a108-b3b264dd2935"
     }
}
```
fail message:<br/>
```json
{
     "code": "1002",
     "message": "[SECURITY_ERROR] Device token is invalid or not verified",
     "result": {
         "device_token": "DE06521F-7E3C-4B4C-A031-8B4828A30697",
         "session_token": "59d0e350-79da-11e4-a108-b3b264dd2935"
     }
}
```



### apiName: pay_by_pier
description: pay_by_pier<br/>
apiUrl: ${host}/merchant_api/v1/transaction/pay_by_pier<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；默认0<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
     "merchant_id": "UR0000000001",[用户或者商家id]
     "api_id": "XXXXXXXXXXXXXXXXXXXX",
     "api_secret_key": "XXXXXXXXXXXXXXXXXXXXXX",
     "auth_token": "XXXXXXXXXXXXXXXXXXXX",
     "platform": "1",[1:web;0:IOS]
     "dev_info":"0",
     "amount": "10",[消费金额]
     "currency": "USD",
     "id_in_merchant": "XXXXXXXXXXXX"商户系统的标识,
     "notes":"notesXXXXXXXXXXX"
}
```

response: <==<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {}
}

```

### apiName: pay_by_pier_test
description: pay_by_pier_test<br/>
apiUrl: ${host}/merchant_api/v1/transaction/pay_by_pier_test<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
     "merchant_id": "MC0000000001",[商家id]
     "phone": "XXXXXXXXXXXXXXXXXXXX",[用户电话]
     "country_code": "XXXXXXXXXXXXXXXXXXXXXX",[用户国籍]
     "platform": "1",[1:web;0:IOS]
     "amount": "10",[消费金额]
     "currency": "USD",
     "id_in_merchant": "XXXXXXXXXXXX"商户系统的标识
     "session_token","XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
     "notes":"notesXXXXXXXXXXX"
}
```

response: <==<br/>
```json
{
     "code": "200",
     "message": "OK"

}

```

### apiName: add_customer POST
description: 添加商家模拟交易的customer。<br/>
apiUrl:
${host}/merchant_api/v1/transaction/add_customer<br/>
method: POST<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "name": "test-000001",
    "merchant_id": "MC0000000017",
    "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
}
```

required parameter:<br/>
name, merchant_id, session_token;<br/>

response: <br/>
sucess message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "phone": "PHONE0000004573"
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter phone is missing.",
     "result": null
}
```

### apiName: get_customers POST
description: 添加商家模拟交易的customer。<br/>
apiUrl:
${host}/merchant_api/v1/transaction/get_customers<br/>
method: POST<br/>

request: ==><br/>
query parameter:<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
<br/>

json request parameter:<br/>
```json
{
    "merchant_id": "MC0000000017",
    "session_token": "51162fa9-79cb-11e4-a108-b3b264dd2935"
}
```

required parameter:<br/>
merchant_id, session_token;<br/>

response: <br/>
sucess message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "phone": "PHONE0000004573",
                "created_on": "1421057663000",
                "name": "Test-0001",
                "country_code": "US"
            },
            {
                "phone": "PHONE0000004574",
                "created_on": "1421057884000",
                "name": "Test-0002",
                "country_code": "US"
            }
        ]
    }
}
```

failure message:<br/>
没有传入参数的错误:<br/>
http_code: 400<br/>
```json
{
     "code": "400",
     "message": "parameter merchant_id is missing.",
     "result": null
}
```

## Merchant Dashboard API 1

### apiName: get_balance
description: merchant dashboard ,get current balance<br/>
apiUrl:
${host}/merchant_api/v1/dashboard/get_balance?merchant_id=XXXXXXXXXXXXXX&session_token=XXXXXXXXXXXXXXXXXXXX<br/>
method: GET<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>


response: <==<br/>
success message:<br/>
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "items": [
             {
                 "balance": "10291.24"
             }
         ]
     }
}
```

fail message:<br/>
```json
{"code":"1001","message":"[SECURITY_ERROR] Session token is invalid or expired","result":{"session_token":""}}

```


### apiName: list_payments
description: merchant dashboard ,list payments<br/>
apiUrl: ${host}/merchant_api/v1/dashboard/list_payments<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
sortby:INVOICE_ID|EMAIL|CREATED_TIME|UPDATED_TIME|AMT|CURRENCY
说明：以下为json参数<br/>
```json

{
   "merchant_id":"MC0000000017",
   "start":"0",
   "limit":"2",
   "sortby":"AMT",
   "session_token":"XXXXXXXXXXXXXXXXXXXX"
}

```

response: <==<br/>
success message:<br/>
```json
{
     "code": "200",
     "message": "OK",
     "result": {
         "items": [
             {
                 "amount": "100.00",
                 "id": "CH0000000055",
                 "id_in_merchant": "",
                 "created_on": "1417661709000",
                 "receipt_email": "",
                 "last_updated": "1417661709000",
                 "invoice_id": "",
                 "merchant_id": "MC0000000017",
                 "authorization_token":
"550E8400-E29B-11D4-A716-446655449999",
                 "currency": "USD"
             },
             {
                 "amount": "100.00",
                 "id": "CH0000000060",
                 "id_in_merchant": "",
                 "created_on": "1417663072000",
                 "receipt_email": "",
                 "last_updated": "1417663072000",
                 "invoice_id": "",
                 "merchant_id": "MC0000000017",
                 "authorization_token":
"550E8400-E29B-11D4-A716-446655448888",
                 "currency": "USD"
             }
         ]
     }
}

```



### apiName: get_transactions_by_chargeId
description: merchant dashboard ,get_transactions_by_chargeId<br/>
apiUrl: ${host}/merchant_api/v1/dashboard/get_transactions_by_chargeId?charge_id=XXXXXXXXXXXXXX&session_token=XXXXXXXXXXXXXXXXXXXX<br/>
method: GET<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
     "charge_id": "CH0000000060",
     "session_token":"XXXXXXXXXXXXXXXXXXXX"
}
```

response: <==<br/>
```json

{
     "code": "200",
     "message": "OK",
     "result": {
         "items": [
             {
                 "api_id": "954f1ca8-6017-11e4-b4fe-224455566",
                 "created_on": "1417403872000",
                 "charge_id": "CH0000000060",
                 "local_invoice_id": "",
                 "currency": "USD",
                 "id": "MT0000000062",
                 "amount": "100.00",
                 "to_id": "MC0000000017",
                 "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
                 "from_id": "UR0000000001",
                 "status_bit": "1",
                 "reference_id": "",
                 "last_updated": "1417674970000",
                 "notes": "",
                 "merchant_invoice_id": "",
                 "authorization_token":
"550E8400-E29B-11D4-A716-446655448888"
             },
             {
                 "api_id": "954f1ca8-6017-11e4-b4fe-224455566",
                 "created_on": "1417403872000",
                 "charge_id": "CH0000000060",
                 "local_invoice_id": "",
                 "currency": "USD",
                 "id": "MT0000000063",
                 "amount": "2.92",
                 "to_id": "PierAccount",
                 "device_token": "A46261D7-9B21-4209-A7D3-CDABC941FB5B",
                 "from_id": "MC0000000017",
                 "status_bit": "1",
                 "reference_id": "",
                 "last_updated": "1417674979000",
                 "notes": "",
                 "merchant_invoice_id": "",
                 "authorization_token":
"550E8400-E29B-11D4-A716-446655448888"
             }
         ]
     }
}
```

### apiName: list_dashboard_customers
description: merchant dashboard ,list_user_transaction。<br/>
apiUrl: ${host}/merchant_api/v1/dashboard/list_dashboard_customers<br/>
method: POST<br/>


request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>

```json
{
     "merchant_id": "MC0000000017",[商家id]
     "start_date": "2014-11-10",[开始时间]
     "end_date": "2014-12-03",[结束时间]
     "start": "0",
     "limit": "20",
     "session_token":"XXXXXXXXXXXXXXXXXXXX"
}
```

response: <==<br/>
```json

{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "id": "UR0000000001",
                "first_name": "zy",
                "created_on": "1417411926000",
                "last_name": "ma"
            }
        ]
    }
}


```


### apiName: list_user_transaction
description: merchant dashboard ,list_user_transaction。<br/>
apiUrl: ${host}/merchant_api/v1/dashboard/list_user_transaction<br/>
method: POST<br/>


request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>

```json
{
     "merchant_id": "MC0000000017",[商家id]
      "userId":"UR0000000001",
     "start_date": "2014-11-10",[开始时间]
     "end_date": "2014-12-03",[结束时间]
     "session_token":"XXXXXXXXXXXXXXXXXXXX"

}
```

response: <==<br/>
```json

{
     "code": "200",
     "message": "OK",
     "result": {
         "items": [
             {
                 "amount": "100.00",
                 "from_id": "UR0000000001",
                 "created_on": "1417403872000",
                 "reference_id": "",
                 "charge_id": "CH0000000060",
                 "last_updated": "1417674970000",
                 "notes": "",
                 "local_invoice_id": "",
                 "merchant_invoice_id": "",
                 "currency": "USD"
             },
             {
                 "amount": "100.00",
                 "from_id": "UR0000000001",
                 "created_on": "1417404116000",
                 "reference_id": "",
                 "charge_id": "CH0000000065",
                 "last_updated": "1417674990000",
                 "notes": "",
                 "local_invoice_id": "",
                 "merchant_invoice_id": "",
                 "currency": "USD"
             },
             {
                 "amount": "800.00",
                 "from_id": "UR0000000001",
                 "created_on": "1417402509000",
                 "reference_id": "",
                 "charge_id": "CH0000000055",
                 "last_updated": "1417676271000",
                 "notes": "",
                 "local_invoice_id": "",
                 "merchant_invoice_id": "",
                 "currency": "USD"
             }
         ],
         "items1": [
             {
                 "total_amonut": "1000.00"
             }
         ]
     }
}


```


### apiName: get_merchant_dashboard
apiUrl: ${host}/merchant_api/v1/dashboard/get_merchant_dashboard<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json参数<br/>
```json
{
  "merchant_id": "MC0000000010",
  "start_date": "2014-12-10",
  "end_date": "2015-1-04",
  "session_token":"7215abd3-7fad-11e4-8328-32913f86e6ed",
  "instant_flag":"1"[instantly get dashboard data,default "0"]
  
}

```

response: <==<br/>
```json

{
    "code": "200",
    "message": "OK",
    "result": {
        "total_customers": "1",
        "total_success_transactions": "1",
        "items": [
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1419231600000",
                "customer_created_total": "0"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "1",
                "time_key": "1419490800000",
                "customer_created_total": "1"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1419577200000",
                "customer_created_total": "0"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1419663600000",
                "customer_created_total": "0"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1419750000000",
                "customer_created_total": "0"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1419836400000",
                "customer_created_total": "0"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1419922800000",
                "customer_created_total": "0"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1420009200000",
                "customer_created_total": "0"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "1",
                "time_key": "1420095600000",
                "customer_created_total": "1"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "1",
                "time_key": "1420182000000",
                "customer_created_total": "1"
            },
            {
                "gross_amount": "0.00",
                "success_charge_total": "0",
                "time_key": "1420268400000",
                "customer_created_total": "0"
            }
        ],
        "gross_revenue": "247.04",
        "session_token": "7215abd3-7fad-11e4-8328-32913f86e6ed"
    }
}

```


### apiName: get_monthly_statement
description: merchant dashboard ,get merchant monthly statement<br/>
apiUrl:
${host}/merchant_api/v1/dashboard/get_monthly_statement?merchant_id=XXXXXXXXXXXXXX&session_token=XXXXXXXXXXXXXXXXXXXX<br/>
method: GET<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>

说明：以下为json参数<br/>
```json
{
     "merchant_id": "MC0000000017"
}
```

response: <==<br/>
success message:<br/>
```json

{
     "code": "200",
     "message": "OK",
     "result": {
         "items": [
             {
                 "product_small_url":
"https://photo.pierup.com.s3.amazonaws.com/pier_user/MC0000000017_prod_small.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1419",
                 "phone": "1988892929",
                 "business_type_id": "1",
                 "product_big_url":
"https://photo.pierup.com.s3.amazonaws.com/pier_user/MC0000000017_prod_big.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=141943",
                 "created_on": "1417484047000",
                 "biz_addr_id": "",
                 "business_summary":
"Pierup%3A+a+virtual+credit+card+corporation.",
                 "business_category_id": "1",
                 "country_code": "US",
                 "avg_payment_id": "2",
                 "business_name": "Pier",
                 "logo_big_url":
"https://photo.pierup.com.s3.amazonaws.com/pier_user/MC0000000017_logo_big.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=141943",
                 "email": "adorechen@163.com",
                 "status_bit": "13",
                 "tax_id": "*****1119",
                 "merchant_id": "MC0000000017",
                 "web_site": "http://www.amazon.com/",
                 "logo_small_url":
"https://photo.pierup.com.s3.amazonaws.com/pier_user/MC0000000017_logo_small.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1419"
             }
         ],
         "items2": [
             {
                 "total_return_amount": "0.00",
                 "gross_fee": "8.76",
                 "total_return": "0.00",
                 "total_sales_amount": "300.00",
                 "total_sales": "3.00"
             }
         ],
         "items1": [
             {
                 "amount": "100.00",
                 "from_id": "UR0000000001",
                 "created_on": "1417661709000",
                 "reference_id": "",
                 "charge_id": "CH0000000055",
                 "last_updated": "1417661709000",
                 "notes": "",
                 "local_invoice_id": "",
                 "merchant_invoice_id": "",
                 "currency": "USD"
             },
             {
                 "amount": "100.00",
                 "from_id": "UR0000000001",
                 "created_on": "1417663072000",
                 "reference_id": "",
                 "charge_id": "CH0000000060",
                 "last_updated": "1417663072000",
                 "notes": "",
                 "local_invoice_id": "",
                 "merchant_invoice_id": "",
                 "currency": "USD"
             },
             {
                 "amount": "100.00",
                 "from_id": "UR0000000001",
                 "created_on": "1417663316000",
                 "reference_id": "",
                 "charge_id": "CH0000000065",
                 "last_updated": "1417663316000",
                 "notes": "",
                 "local_invoice_id": "",
                 "merchant_invoice_id": "",
                 "currency": "USD"
             }
         ]
     }
}
```

## MERCHANT TRANSFER API 1
### apiName: get_merchant_transfer_info
description: 获取商家转账信息。<br/>
apiUrl: ${host}/merchant_api/v1/transfer/get_merchant_transfer_info<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求数据<br/>
```json
{
     "merchant_id": "MC0000000134",
     "currency": "USD",
     "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "bank_accounts": [
            {
                "bank_id": "BI9000000003",
                "bank_name": "Northmark Bank",
                "account_number": "123****899",
                "image_url": "",
                "verified": "1",
                "is_primary": "0",
                "merchant_id": "MC0000000134",
                "bank_account_id": "BK0000000206",
                "type_id": "2"
            },
            {
                "bank_id": "BI9000000003",
                "bank_name": "Northmark Bank",
                "account_number": "123****811",
                "image_url": "",
                "verified": "1",
                "is_primary": "0",
                "merchant_id": "MC0000000134",
                "bank_account_id": "BK0000000207",
                "type_id": "2"
            },
            {
                "bank_id": "BI9000000003",
                "bank_name": "Northmark Bank",
                "account_number": "999****999",
                "image_url": "",
                "verified": "0",
                "is_primary": "1",
                "merchant_id": "MC0000000134",
                "bank_account_id": "BK0000001199",
                "type_id": "1"
            },
            {
                "bank_id": "BI9000000003",
                "bank_name": "Northmark Bank",
                "account_number": "111****223",
                "image_url": "",
                "verified": "0",
                "is_primary": "0",
                "merchant_id": "MC0000000134",
                "bank_account_id": "BK0000001201",
                "type_id": "2"
            }
        ],
        "current_balance": "3084.28",
        "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: transfer_merchant_to_pier
description: 商家向pier转账。<br/>
apiUrl: ${host}/merchant_api/v1/transfer/transfer_merchant_to_pier<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求数据<br/>
```json
{
    "merchant_id": "MC0000000134",
    "currency": "USD",
    "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c",
    "amount": "100",
    "notes": "转账",
    "account_id": "BK0000000206",
    "transfer_date": "2015-01-08"[指定执行转账日期]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "amount": "100.00",
        "bank_name": "Northmark Bank",
        "account_number": "123*****990",
        "account_id": "BK0000000206",
        "status": "pending",
        "image_url": "",
        "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: transfer_pier_to_merchant
description: pier向商家转账。<br/>
apiUrl: ${host}/merchant_api/v1/transfer/transfer_pier_to_merchant<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求数据<br/>
```json
{
    "merchant_id": "MC0000000134",
    "currency": "USD",
    "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c",
    "amount": "100",
    "notes": "转账",
    "account_id": "BK0000000206",
    "transfer_date": "2015-01-08"[指定执行转账日期]
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "amount": "100.00",
        "bank_name": "Northmark Bank",
        "account_number": "123*****990",
        "account_id": "BK0000000206",
        "status": "pending",
        "image_url": "",
        "merchant_transfer_id": "MF0000004538",
        "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c"
    }
}
```
fail message:<br/>
```json
{
    "code": "1001",
    "message": "[SECURITY_ERROR] Session token is invalid or expired",
    "result": {
        "session_token": null
    }
}
```

### apiName: get_merchant_transfer_list
description: 获取商家转账列表。<br/>
apiUrl: ${host}/merchant_api/v1/transfer/get_merchant_transfer_list<br/>
method: POST<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>

说明：以下为json请求数据<br/>
```json
{
    "merchant_id": "MC0000000134",
    "currency": "USD",
    "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c",
    "page_no": "1",[为空或非法，默认为1]
    "limit": "20"[为空或非法，默认为20],
    "start_date":"2015-01-08",
    "end_date":"2015-01-09"
}
```

response: <==<br/>
success message:<br/>
```json
{
    "code": "200",
    "message": "OK",
    "result": {
        "items": [
            {
                "amount": "100.00",
                "id": "MF0000004208",
                "bank_name": "Northmark Bank",
                "account_number": "123*****990",
                "account_id": "BK0000000206",
                "image_url": "",
                "created_on": "1420698924000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "+",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "id": "MF0000004210",
                "bank_name": "Northmark Bank",
                "account_number": "123*****990",
                "account_id": "BK0000000206",
                "image_url": "",
                "created_on": "1420699538000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "id": "MF0000004451",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774133000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "id": "MF0000004452",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774209000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "id": "MF0000004453",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774290000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "200.00",
                "id": "MF0000004454",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774327000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "+",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "id": "MF0000004455",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774778000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "+",
                "currency": "USD"
            },
            {
                "amount": "200.00",
                "id": "MF0000004456",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774796000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "id": "MF0000004457",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774817000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "200.00",
                "id": "MF0000004458",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774822000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "300.00",
                "id": "MF0000004459",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774827000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "500.00",
                "id": "MF0000004460",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774850000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "+",
                "currency": "USD"
            },
            {
                "amount": "200.00",
                "id": "MF0000004461",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774895000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "300.00",
                "id": "MF0000004462",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420774901000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "+",
                "currency": "USD"
            },
            {
                "amount": "100.00",
                "id": "MF0000004463",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420779897000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "+",
                "currency": "USD"
            },
            {
                "amount": "500.00",
                "id": "MF0000004464",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420779906000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "29.00",
                "id": "MF0000004468",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420781673000",
                "notes": "转账",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "200.00",
                "id": "MF0000004473",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420788427000",
                "notes": "transfer",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            },
            {
                "amount": "200.00",
                "id": "MF0000004474",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420788440000",
                "notes": "transfer",
                "merchant_id": "MC0000000134",
                "option": "+",
                "currency": "USD"
            },
            {
                "amount": "300.00",
                "id": "MF0000004475",
                "bank_name": "Northmark Bank",
                "account_number": "999*****990",
                "account_id": "BK0000001199",
                "image_url": "",
                "created_on": "1420788449000",
                "notes": "transfer",
                "merchant_id": "MC0000000134",
                "option": "-",
                "currency": "USD"
            }
        ],
        "current_balance": "1812.28",
        "total_count": "35",
        "session_token": "c9db46af-96fd-11e4-aad2-0ea81fa3d43c"
    }
}
```

## MERCHANT FAKE SERVICE API 1
### apiName: products
description: 获取指定商家fake的产品列表。<br/>
apiUrl: ${host}/merchant_api/v1/fake/products<br/>
method: GET<br/>

request: ==><br/>
说明：以下为url参数<br/>
dev_info: 0 表示正式数据库， 1表示测试数据库；<br/>
platform: 0 表示IOS, 1表示WEB；<br/>
merchant_id:商家id<br/>


response: <==<br/>
success message:<br/> 
```json
{
    "message": "OK",
    "result": [
        {
            "amount": "65.59",
            "image": "http://photo.pierup.com.s3.amazonaws.com/pier_other/MC0000000134_TB1.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1740808941&Signature=vidmB8nWq8jn19jQ8Z7aOP%2BQUh4%3D",
            "currency": "USD"
        },
        {
            "amount": "74.67",
            "image": "http://photo.pierup.com.s3.amazonaws.com/pier_other/MC0000000134_TB2.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1740809064&Signature=3lHptljylUMAxFnSlAI3fEMcEiU%3D",
            "currency": "USD"
        },
        {
            "amount": "98.76",
            "image": "http://photo.pierup.com.s3.amazonaws.com/pier_other/MC0000000134_TB3.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1740809134&Signature=%2B5snOidPaDo7fugLr%2BU8B13uO7E%3D",
            "currency": "USD"
        },
        {
            "amount": "111.45",
            "image": "http://photo.pierup.com.s3.amazonaws.com/pier_other/MC0000000134_TB4.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1740809186&Signature=FN4rpOyOA2XxCxyoDqK10VtD%2B4U%3D",
            "currency": "USD"
        },
        {
            "amount": "79.33",
            "image": "http://photo.pierup.com.s3.amazonaws.com/pier_other/MC0000000134_TB5.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1740809245&Signature=ZLe1ziah3LXnMksxB6WLr02btG4%3D",
            "currency": "USD"
        },
        {
            "amount": "97.96",
            "image": "http://photo.pierup.com.s3.amazonaws.com/pier_other/MC0000000134_TB6.jpg?AWSAccessKeyId=AKIAI4D3PSTIFO52RYUQ&Expires=1740809489&Signature=U1%2B4E9Aw4FQurYr2PiQJdUTeG%2F0%3D",
            "currency": "USD"
        }
    ],
    "server_url": "http://pierup.ddns.net:8686/merchant/server/sdk/pay/AAA000000001",
    "code": "200",
    "merchant_id": "AAA000000001"
}
```
