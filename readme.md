先启动solr服务,建立ukyo搜索实例
如果不叫ukyo,需要更改->
SolrUtil.java中的url = "http://localhost:8983/solr/ukyo";

solr的启动
切换到solr安装目录/bin下
执行:
solr.cmd start