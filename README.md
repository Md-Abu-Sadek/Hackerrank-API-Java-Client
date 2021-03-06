# Hackerrank-API-Java-Client
A solution of "How to manage a Java Client to compile and execute code in Hackerrank REST API ?".
# What is Hackerrank API?
[Hackerrank API](https://www.hackerrank.com/api) is a REST web service of [Hackerrank.com](https://www.hackerrank.com) to compile & execute source code provided by clients as a HTTP request. It can work on more than 50 languages. It requires some arguments of HTTP post request and returns information in JSON/XML format as a HTTP response.
# Why one should use Hackerrank API?
Generally API's are for development purpose. So one can develop an online comiler/judge using this API. One can also develop an online "programming contest" system using this API.
# Why "Hackerrank-API-Java-Client"?
One who wants to develop a online comilation/judge system(web application) using JAVA may go through this work. It explains how to initialize, How to make a successfull HTTP request and how to retrive information using JAVA programming languages. It also introduces some usefull "dependencies". One can get a clear idea on "how to do it".
# Language:
* JAVA 8
# Dependencies:
* httpclient-4.5.2
* httpcore-4.4.8
* org.json
* commons-logging-1.1.3-api
# How it works?
We have to register in Hackerrank.com & also register in Hackerrank API as a client. We will get our "api_key". We have to provide "source" as string and "testcases" as JSON(Javascript object notation) format string. We have to know the corresponding language code "lang". These four arguments are "MUST" for our HTTP post request. We have to create a client connection with "url". A successful request will return us a HTTP response. Then we have to retrieve our desiered JSON format information from this response. This JSON objct wil be like:

```
{
    "result":
    {
        "callback_url":"",
        "censored_compile_message":"",
        "codechecker_hash":"run-zn5OjyHm3z698HTR0Oeg",
        "compile_command":"python -mpy_compile  solution.py 1> compile.err 2>&1",
        "compilemessage":"",
        "error_code":0,
        "hash":"1515352927-202009908",
        "loopback":null,
        "memory":[7294976],
        "message":["Success"],
        "response_s3_path":"2018_01_07_19\/gHy0edrouFEZzlx2RmNDtOWa4MQs7VKLj9fIU1pTnJYBAkvhS85a52735f719262.48271893",
        "result":0,
        "run_command":"",
        "server":"ip-10-10-87-153",
        "signal":[0],
        "stderr":[false],
        "stdout":["The name of our country is Bangladesh.\n"],
        "time":[0]
    }
}
```
