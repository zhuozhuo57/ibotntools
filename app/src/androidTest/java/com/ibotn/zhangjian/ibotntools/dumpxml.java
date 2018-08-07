/*
package com.ibotn.zhangjian.ibotntools;

import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class dumpxml extends UiAutomatorInstrumentationTestRunner {
    public UiDevice device;
    public UiObject object;
    public UiWatcher uiWatcher;
    public UiScrollable uiScrollable;
    public UiSelector uiSelector;
    public static String Person;
    public static List<Person> paseXml(InputStream is) throws Exception {

        //新建一个集合，用于存放解析后的对象
        List<Person> personList = new ArrayList<Person>();
        //创建对象引用
        Person person = null;
        //得到 Dom 解析对象工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //通过工厂创建 Dom 解析对象实例
        DocumentBuilder db = factory.newDocumentBuilder();
        //将 xml 文件的输入流交给 Dom 解析对象进行解析，并将 Dom 树返回。
        Document document = db.parse(is);
        //通过 Dom 树接收到根元素
        Element rootElement = document.getDocumentElement();
        //通过根元素获得下属的所有名字为 person 节点
        NodeList nodeList = rootElement.getElementsByTagName("person");
        //遍历取出来的 person 节点集合
        for (int i = 0; i < nodeList.getLength(); i++) {
            //得到一个 person 节点
            Element personElement = (Element) nodeList.item(i);
            //新建一个 Person 对象
            person = new Person();
            //将 xml 标签的 Id 属性值赋值给 Person 对象的 Id 属性
            person.setId(new Integer(personElement.getAttribute("id")));

            //得到 person 标签的下属所节点
            NodeList personChildList = personElement.getChildNodes();
                //循环的到的下属标签
            for (int y = 0; y < personChildList.getLength(); y++) {
                //创建一个引用，指向循环的标签
                Node node = personChildList.item(y);

                //如果此循环出来的元素是 Element 对象，即标签元素，那么执行以下代码
                if (Node.ELEMENT_NODE == node.getNodeType()) {

                //如果这个标签的名字是 name，那么得到它的值，赋值给Person 对象
                    if ("name".equals(node.getNodeName())) {
                        String nameValue = node.getFirstChild().getNodeValue();
                        person.setName(nameValue);

                    }
                //如果这个标签的名字是 age，那么得到它的值，赋值给Person 对象
                    if ("age".equals(node.getNodeName())) {
                        String ageValue = node.getFirstChild(
                        ).getNodeValue();
                        person.setAge(new Short(ageValue));
                    }
                }
            }
            //将此 person 对象添加到 personList 中
            personList.add(person);
            //将 person 制空
            person = null;
        }
//返回 xml 解析后得到的对象集合
        return personList;
    }
    public boolean click(String text, String resourceid, int index, int[] point) throws IOException {
        device.executeShellCommand("adb root");
        device.executeShellCommand("adb shell uiautomator dump ");
        File file = new File("/storage/sdcard/window_dump.xml");
        //output

        return true;
    }

}

}
*/
