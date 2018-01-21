package wekaTest;
import java.io.File;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Classifier m_classifier = new J48();
	        File inputFile = new File("C://Program Files//Weka-3-8//data//cpu.with.vendor.arff");//ѵ�������ļ�
	        ArffLoader atf = new ArffLoader(); 
	        atf.setFile(inputFile);
	        Instances instancesTrain = atf.getDataSet(); // ����ѵ���ļ�    
	        inputFile = new File("C://Program Files//Weka-3-8//data//cpu.with.vendor.arff");//���������ļ�
	        atf.setFile(inputFile);          
	        Instances instancesTest = atf.getDataSet(); // ��������ļ�
	        instancesTest.setClassIndex(0); //���÷������������кţ���һ��Ϊ0�ţ���instancesTest.numAttributes()����ȡ����������
	        double sum = instancesTest.numInstances(),//��������ʵ����
	        right = 0.0f;
	        instancesTrain.setClassIndex(0);
	 
	        m_classifier.buildClassifier(instancesTrain); //ѵ��            
	        for(int  i = 0;i<sum;i++)//���Է�����
	        {
	            if(m_classifier.classifyInstance(instancesTest.instance(i))==instancesTest.instance(i).classValue())//���Ԥ��ֵ�ʹ�ֵ��ȣ����������еķ������ṩ����Ϊ��ȷ�𰸣�����������壩
	            {
	              right++;//��ȷֵ��1
	            }
	            return;
	        }
	        System.out.println("J48 classification precision:"+(right/sum));
	}

}
