# AWS API Gateway Mapping Template Playground

The AWS API Gateway uses Apache Velocity to transform requests into JSON.
This project emulates aspects of the mapping environment to make it easier to test templates.

History: this project exists to improve and test the application/x-www-form-urlencoded template created by avilewin in an [API Gateway post](https://forums.aws.amazon.com/message.jspa?messageID=675886).
The version used here derives from work by [Christian E Willman](https://github.com/christianewillman/aws-api-gateway-bodyparser)


# Using this Playground

Two ways:

1. Use the _runner.scala_ script to set up and execute a template; or

2. Write a ScalaTest test for your template in _src/test/scala_.

Either way what you do is:

- write a `.vm` template
- set up a `Context`, `Input` instance
- use `Runner` to execute your scenario

# Status

The gateway defines a variety of methods and values.
Their status in this project is described below.

Descriptions in italic are from the AWS Documentation.

## Util

- [ ] `$util.escapeJavaScript()` - _Escapes the characters in a string using JavaScript string rules._
- [ ] `$util.urlEncode()` - _Converts a string into "application/x-www-form-urlencoded" format._
- [x] `$util.urlDecode() : String => String` - _Decodes an "application/x-www-form-urlencoded" string._
- [ ] `$util.base64Encode()` - _Encodes the data into a base64-encoded string._
- [ ] `$util.base64Decode()` - _Decodes the data from a base64-encoded string._

## Context

- [ ] `$context.apiId` - _ The identifier API Gateway assigns to your API._
- [x] `$context.httpMethod` - _ The HTTP method used. Valid values include: DELETE, GET, HEAD, OPTIONS, PATCH, POST, and PUT._
- [ ] `$context.identity.accountId` - _ The AWS account ID associated with the request._
- [ ] `$context.identity.apiKey` - _ The API owner key associated with your API._
- [ ] `$context.identity.caller` - _ The principal identifier of the caller making the request._
- [ ] `$context.identity.cognitoAuthenticationProvider` - _ The Amazon Cognito authentication provider used by the caller making the request. Available only if the request was signed with Amazon Cognito credentials._
- [ ] `$context.identity.cognitoAuthenticationType` - _ The Amazon Cognito authentication type of the caller making the request. Available only if the request was signed with Amazon Cognito credentials._
- [ ] `$context.identity.cognitoIdentityId` - _ The Amazon Cognito identity ID of the caller making the request. Available only if the request was signed with Amazon Cognito credentials._
- [ ] `$context.identity.cognitoIdentityPoolId` - _ The Amazon Cognito identity pool ID of the caller making the request. Available only if the request was signed with Amazon Cognito credentials._
- [ ] `$context.identity.sourceIp` - _ The IP address of the API caller as determined by the X-Forwarded-For header. Note that this should not be used for security purposes. To get the full value of X-Forwarded-For addresses you can define the X-Forwarded-For header in your API and then map it to your integration._
- [ ] `$context.identity.user` - _ The principal identifier of the user making the request._
- [ ] `$context.identity.userAgent` - _ The User Agent of the API caller._
- [ ] `$context.identity.userArn` - _ The Amazon Resource Name (ARN) of the effective user identified after authentication._
- [ ] `$context.requestId` - _ An automatically generated ID for the API call._
- [ ] `$context.resourceId` - _ The identifier API Gateway assigns to your resource._
- [ ] `$context.resourcePath` - _ The path to your resource. For more information, see Create a Resource._
- [ ] `$context.stage` - _ The deployment stage of the API call (for example, Beta or Prod)._

## Input

- [ ] `$input.json(x)` - _ This function evaluates a JSONPath expression and returns the results as a JSON string._
- [ ] `$input.params()` - _ Returns a map of all the request parameters of your API call._
- [ ] `$input.params(x)` - _ Returns the value of a method request parameter from the path, query string, or header value (in that order) given a parameter name string x._
- [x] `$input.path(x)` **Only implemetned for input $ so far**- _ Takes a JSONPath expression string (x) and returns an object representation of the result. This allows you to access and manipulate elements of the payload natively in Apache Velocity Template Language (VTL)._

## StageVariables

TODO

# References

- [API Gateway Mapping Template Reference](http://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-mapping-template-reference.html)

- [Apache Velocity User Guide](http://velocity.apache.org/engine/releases/velocity-1.7/user-guide.html)
