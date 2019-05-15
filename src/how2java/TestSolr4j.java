package how2java;

import java.io.IOException;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class TestSolr4j {

	public static void main(String[] args) throws SolrServerException, IOException {
		//查询
		QueryResponse queryResponse = SolrUtil.query("手机",0,10);
		SolrDocumentList documents=	queryResponse.getResults();
		System.out.println("累计找到的条数："+documents.getNumFound());
		long l = (documents.getNumFound() / 10)+1;
		for(int i=0;i<l;i++){
			QueryResponse documentsTrue = SolrUtil.query("手机", i, 10);
			SolrDocumentList results = documentsTrue.getResults();
			soutResult(results);
		}

	}

	//输出结果
	private static void soutResult(SolrDocumentList results){
		//title
		if(!results.isEmpty()){

			Collection<String> fieldNames = results.get(0).getFieldNames();
			for (String fieldName : fieldNames) {
				System.out.print(fieldName+"\t");
			}
			System.out.println();
		}
		//content
		for (SolrDocument solrDocument : results) {

			Collection<String> fieldNames= solrDocument.getFieldNames();

			for (String fieldName : fieldNames) {
				System.out.print(solrDocument.get(fieldName)+"\t");

			}
			System.out.println();

		}
	}


}
