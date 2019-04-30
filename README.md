# xposedtest
### 该项目为xposed模块开发最初的模板, 创建于2019/04/30
编写代码后用gradle sync一下，如果没有任何问题，需要测试，则先创建自己的发包签名，然后发布正式包，注意不要发布到C盘。

### 温馨提示：
如果发现handleLoadPackage()接口的loadPackageParam参数的值不用正常，或者出现NullpointerException异常，不要激动，
这90%是因为你发布了debug包或者没有签名导致xposed框架对你的模块特殊对待而已。改为正式发布签名apk就可以了。
