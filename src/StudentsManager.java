import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Mercedesning
 *		学生管理系统
 *
 */

public class StudentsManager {

	public static void main(String[] args) {
		//创建集合对象，用于存储学生对象
		ArrayList<Student> array = new ArrayList<>();
		
		
		//while 循环实现死循环
		while(true) {
			System.out.println("--------欢迎进入学生管理系统--------");
			System.out.println("1.添加学生");
			System.out.println("2.删除学生");
			System.out.println("3.修改学生");
			System.out.println("4.查看所有学生");
			System.out.println("5.退出");
			System.out.println("请输入你的选择：");
			
			//Scanner 录入
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			
			//Switch 完成选择操作
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
				System.out.println("谢谢使用");
				System.exit(0);//JVM退出
				}
		}
	}
	
	
	
	public static void addStudent(ArrayList<Student> array) {
		//录入学生信息
		Scanner sc = new Scanner(System.in);
		
		String sid;
		
		while(true) {
			System.out.println("请输入学生学号：");
			sid = sc.nextLine();
			
			boolean flog=isUsed(array,sid);
			if(flog) {
				System.out.println("你输入的学号已经被使用，请重新输入！");
			}else break;
		}
		System.out.println("请输入学生姓名：");
		String name = sc.nextLine();
		System.out.println("请输入学生年龄：");
		String age = sc.nextLine();
		System.out.println("请输入学生居住地：");
		String address = sc.nextLine();
		
		//创建学生对象
		Student s = new Student();
		s.setSid(sid);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		
		
		//将学生对象添加到ArrayList中
		array.add(s);
		
		//输出成功提示
		System.out.println("添加学生成功！");
		
	}
	public static boolean isUsed(ArrayList<Student> array,String sid) {
		//判断学号是否被使用
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
		//查看学生
		
		//判断有无数据
		if(array.size()==0) {
			System.out.println("无数据，请添加数据");
			return;
		}
		
		//显示表头信息
		System.out.println("学号\t姓名\t年龄\t居住地\t");
		
		//遍历集合
		for(Student element : array) {
			System.out.println(element.getSid()+"\t"
								+element.getName()+"\t"
								+element.getAge()+"岁\t"
								+element.getAddress());
		}
	}
	
	
	
	public static void deleteStudent(ArrayList<Student> array) {
		//删除学生信息
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("请输入你要删除的学生学号为：");
		String sid = sc.nextLine();
		
		//执行删除操作前，对学号是否存在进行判断
		//如果不存在，则显示提示信息
		//如果存在，执行删除、修改操作
		int index=-1;
		for(int i =0 ;i<array.size();i++) {
			Student s =array.get(i);
			if(s.getSid().equals(sid)) {
				index=i;
				break;
			}
		}
		if(index==-1) {
			System.out.println("该信息不存在， 请重新输入！");
		}else {
			array.remove(index);
			System.out.println("删除学生成功！");
			break;
		}
		}
	}
	
	
	public static void updateStudent(ArrayList<Student> array) {
		//输入要修改的学生学号
		Scanner sc = new Scanner(System.in);	
		System.out.println("请输入要修改的学生学号：");
		String sid = sc.nextLine();
		
		System.out.println("请选择要修改的内容：");
		System.out.println("1.修改学生的姓名");
		System.out.println("2.修改学生的年龄");
		System.out.println("3.修改学生的居住地");
		
		Scanner scc = new Scanner(System.in);
		String line = scc.nextLine();
		Student s = new Student();//创建学生对象
		switch(line) {
				//键盘录入要修改的学生信息
			case "1":	
				System.out.println("请输入学生新姓名：");
				String name = sc.nextLine();
				s.setName(name);
				break;
			case "2":
				System.out.println("请输入学生新年龄：");
				String age = sc.nextLine();
				s.setAge(age);
				break;
			case "3":
				System.out.println("请输入学生新居住地：");
				String address = sc.nextLine();
				s.setAddress(address);
				break;
			case "4":
				System.out.println("请输入学生新姓名：");
				String names = sc.nextLine();
				System.out.println("请输入学生新年龄：");
				String ages = sc.nextLine();
				System.out.println("请输入学生新居住地：");
				String addresss = sc.nextLine();
				s.setName(names);
				s.setAge(ages);
				s.setAddress(addresss);
				break;
				
		}
		s.setSid(sid);
		
		//遍历集合修改对应的学生信息
		for(int i = 0;i<array.size();i++) {
			Student student =array.get(i);
			if(student.getSid().equals(sid)) {
				array.set(i, s);
				break;
			}
		}
		//输出修改成功提示
		System.out.println("修改学生信息成功！");
	}
}
