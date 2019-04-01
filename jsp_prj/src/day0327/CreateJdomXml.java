package day0327;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateJdomXml {
	
	public List<String> data(){
		List<String> list =new ArrayList<String>();
		list.add("�����Դ³�");
		list.add("ȭ���ϰԸԴ³�");
		list.add("�������̸Դ³�");
		list.add("���� ������ �Դ³�");
		list.add("�ݻ��԰� �� �Դ³�");
		list.add("���ϸ鼭 �Դ³�");
		list.add("������ ã�ƴٴϸ� �Դ³�");
		return list;
	}//data
	
	public Document createXml(List<String> weekMsg) {
		//1. xml������ü ����
		Document doc = new Document();
		//2. �ֻ��� �θ� ��� ����
		Element rootNode = new Element("week");
		Element msgNode = null;
		for(String data: weekMsg) {
			//3. �ڽ� ��� ����
			msgNode= new Element("msg");
			//4. �ڽ� ��忡 �� ����
			msgNode.setText(data);
			//5. ���� ���� �ڽ� ��带 �θ� ��忡 �߰�
			rootNode.addContent(msgNode);
			
		}//end for
		//6. �ڽĳ�带 ���� �θ��带 xml������ü�� �߰�
		doc.addContent(rootNode);
		
		return doc;
	}//createXml
	
	public void createXmlFile(Document doc)throws IOException {
		//7. ��� ��ü ���� : compact, rawformat�� ���ٷ� ����Ѵ�.
		XMLOutputter x_out= new XMLOutputter(Format.getPrettyFormat() );
		//8. xml������ü�� ��½�Ʈ�� ����Ͽ� ���
		x_out.output(doc, System.out);
		x_out.output(doc, new FileOutputStream("C:/dev/workspace/jsp_prj/WebContent/xml0327/jdom_msg.xml"));
	}//createXmlFile
	
	public static void main(String[] args) {
		CreateJdomXml c= new CreateJdomXml();
		try {
			c.createXmlFile(c.createXml(c.data()));
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}
}