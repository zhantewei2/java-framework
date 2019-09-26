from hashlib import md5
import time
import json
import base64
import requests as req


api_key="b2f3f0acb3e04664b97de8837f5d9089"

secret_key="002b7f6f1b4946c098a830155bec3c6b"

_time=int(time.time()*1000)

signStr=api_key+secret_key+str(_time)

signStr=md5(bytes(signStr,"utf8")).hexdigest()

jsonStr={
    "apiKey":api_key,
    "time":str(_time),
    "sign":signStr
}
jsonStr=json.dumps(jsonStr)

end_str=base64.b64encode(jsonStr.encode("utf8"))
end_str=str(end_str,'utf8')
print(end_str)

result=req.post(
    "http://dev.cmccopen.cn/api/v1/voice/twoWayCall",
    headers={
        "Content-Type":"application/json;charset=UTF-8",
        "Authorization":end_str
    },
    json={
        "voiceNumber":"075561949775",
        "from":"13122021632",
        "to":"13023210566"
    }
)


print(result)
print(result.content)