import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Mercedesning
 *		ѧ������ϵͳ
 *
 */

public class StudentsManager {

	public static void main(String[] args) {
		//�������϶������ڴ洢ѧ������
		ArrayList<Student> array = new ArrayList<>();
		
		
		//while ѭ��ʵ����ѭ��
		while(true) {
			System.out.println("--------��ӭ����ѧ������ϵͳ--------");
			System.out.println("1.���ѧ��");
			System.out.println("2.ɾ��ѧ��");
			System.out.println("3.�޸�ѧ��");
			System.out.println("4.�鿴����ѧ��");
			System.out.println("5.�˳�");
			System.out.println("���������ѡ��");
			
			//Scanner ¼��
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			
			//Switch ���ѡ�����
			switch(line) {
			case "1":
				addStudent(array);
				break;
			case "2":
				deleteStudent(array);
				break;
			case "3":
				updateStudent(array);
				break;
			case "4":
				findAllStudent(array);
				break;
			case "5":
				System.out.println("ллʹ��");
				System.exit(0);//JVM�˳�
				}
		}
	}
	
	
	
	public static void addStudent(ArrayList<Student> array) {
		//¼��ѧ����Ϣ
		Scanner sc = new Scanner(System.in);
		
		String sid;
		
		while(true) {
			System.out.println("������ѧ��ѧ�ţ�");
			sid = sc.nextLine();
			
			boolean flog=isUsed(array,sid);
			if(flog) {
				System.out.println("�������ѧ���Ѿ���ʹ�ã����������룡");
			}else break;
		}
		System.out.println("������ѧ��������");
		String name = sc.nextLine();
		System.out.println("������ѧ�����䣺");
		String age = sc.nextLine();
		System.out.println("������ѧ����ס�أ�");
		String address = sc.nextLine();
		
		//����ѧ������
		Student s = new Student();
		s.setSid(sid);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		
		
		//��ѧ��������ӵ�ArrayList��
		array.add(s);
		
		//����ɹ���ʾ
		System.out.println("���ѧ���ɹ���");
		
	}
	public static boolean isUsed(ArrayList<Student> array,String sid) {
		//�ж�ѧ���Ƿ�ʹ��
		boolean flog =false;
		for(int i=0;i<array.size();i++) {
			Student s=array.get(i);
			if(s.getSid().equals(sid)) {
				flog=true;
				break;
			}
		}
		return flog;
	}
	
	public static void findAllStudent(ArrayList<Student> array) {
		//�鿴ѧ��
		
		//�ж���������
		if(array.size()==0) {
			System.out.println("�����ݣ����������");
			return;
		}
		
		//��ʾ��ͷ��Ϣ
		System.out.println("ѧ��\t����\t����\t��ס��\t");
		
		//��������
		for(Student element : array) {
			System.out.println(element.getSid()+"\t"
								+element.getName()+"\t"
								+element.getAge()+"��\t"
								+element.getAddress());
		}
	}
	
	
	
	public static void deleteStudent(ArrayList<Student> array) {
		//ɾ��ѧ����Ϣ
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("��������Ҫɾ����ѧ��ѧ��Ϊ��");
		String sid = sc.nextLine();
		
		//ִ��ɾ������ǰ����ѧ���Ƿ���ڽ����ж�
		//��������ڣ�����ʾ��ʾ��Ϣ
		//������ڣ�ִ��ɾ�����޸Ĳ���
		int index=-1;
		for(int i =0 ;i<array.size();i++) {
			Student s =array.get(i);
			if(s.getSid().equals(sid)) {
				index=i;
				break;
			}
		}
		if(index==-1) {
			System.out.println("����Ϣ�����ڣ� ���������룡");
		}else {
			array.remove(index);
			System.out.println("ɾ��ѧ���ɹ���");
			break;
		}
		}
	}
	
	
	public static void updateStudent(ArrayList<Student> array) {
		//����Ҫ�޸ĵ�ѧ��ѧ��
		Scanner sc = new Scanner(System.in);	
		System.out.println("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		String sid = sc.nextLine();
		
		System.out.println("��ѡ��Ҫ�޸ĵ����ݣ�");
		System.out.println("1.�޸�ѧ��������");
		System.out.println("2.�޸�ѧ��������");
		System.out.println("3.�޸�ѧ���ľ�ס��");
		
		Scanner scc = new Scanner(System.in);
		String line = scc.nextLine();
		Student s = new Student();//����ѧ������
		switch(line) {
				//����¼��Ҫ�޸ĵ�ѧ����Ϣ
			case "1":	
				System.out.println("������ѧ����������");
				String name = sc.nextLine();
				s.setName(name);
				break;
			case "2":
				System.out.println("������ѧ�������䣺");
				String age = sc.nextLine();
				s.setAge(age);
				break;
			case "3":
				System.out.println("������ѧ���¾�ס�أ�");
				String address = sc.nextLine();
				s.setAddress(address);
				break;
			case "4":
				System.out.println("������ѧ����������");
				String names = sc.nextLine();
				System.out.println("������ѧ�������䣺");
				String ages = sc.nextLine();
				System.out.println("������ѧ���¾�ס�أ�");
				String addresss = sc.nextLine();
				s.setName(names);
				s.setAge(ages);
				s.setAddress(addresss);
				break;
				
		}
		s.setSid(sid);
		
		//���������޸Ķ�Ӧ��ѧ����Ϣ
		for(int i = 0;i<array.size();i++) {
			Student student =array.get(i);
			if(student.getSid().equals(sid)) {
				array.set(i, s);
				break;
			}
		}
		//����޸ĳɹ���ʾ
		System.out.println("�޸�ѧ����Ϣ�ɹ���");
	}
}
