

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ZooClub {

	Map<Person, List<Pet>> map;

	ZooClub() {

		map = new HashMap<>();

	}

	public static void showMenu() {
		System.out.println("\n1) ������ �������� � ����" + "\n2) ������ �������� �� �������� �����."
				+ "\n3) �������� �������� � ��������." + "\n4) �������� �������� �����."
				+ "\n5) �������� ��������� �������� � ��� ��������." + "\n6) ������� �� ����� �������."
				+ "\n7) ����� � ��������");
	}

	public void addPerson() {// dodatu vlasnuka

		System.out.println("������ ��� �������� �����: ");
		Scanner scaddPerson = new Scanner(System.in);
		String name = scaddPerson.nextLine();

		System.out.println("������ �� �������� �����: ");
		Scanner scaddPerson1 = new Scanner(System.in);
		int age = scaddPerson1.nextInt();

		map.put(new Person(name, age), new ArrayList<Pet>());

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();
		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			System.out.println("Name - "+temp.getKey().getName()+" ,  age = "+temp.getKey().getAge()+";");
		}
	}

	// ����� ��������� �������� �� �������
	public void addPet() {

		System.out.println("������ ��� ��������");
		Scanner scAddPet = new Scanner(System.in);
		String nameown = scAddPet.nextLine();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();

		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			if (temp.getKey().getName().equalsIgnoreCase(nameown)) {

				System.out.println("������ ��� �������� �� ������: ");
				Scanner sctype = new Scanner(System.in);
				String type = sctype.nextLine();

				System.out.println("������ ��� ��������: ");
				Scanner sc1 = new Scanner(System.in);
				String name = sc1.nextLine();

				temp.getValue().add(new Pet(type, name));
				
				System.out.println(temp.getKey().getName()+" �� "+type+"- "+name);
			}
	}
	}
	public void removePet() {// vudalutu
								// tvarunky Map<Person, List<Pet>> map
		System.out.println("������ ��� ��������");
		Scanner scRemovePet = new Scanner(System.in);
		String nameown = scRemovePet.nextLine();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();

		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			if (temp.getKey().getName().equals(nameown)) {

				System.out.println("������ ��� �������� �� ���������: ");
				Scanner scRemovePet1 = new Scanner(System.in);
				String type = scRemovePet1.nextLine();

				System.out.println("������ ��� ��������: ");
				Scanner scRemovePet2 = new Scanner(System.in);
				String name = scRemovePet2.nextLine();

				temp.getValue().remove(new Pet(type, name));
				System.out.println("�������� ��������");
			}

		}
	}

	public void removePerson() {

		System.out.println("������ ��� ��������");
		Scanner scRemovePerson = new Scanner(System.in);
		String nameown = scRemovePerson.nextLine();

		System.out.println("������ �� ��������:");
		Scanner scRemovePerson1 = new Scanner(System.in);
		int age = scRemovePerson1.nextInt();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter2 = setMap.iterator();

		while (iter2.hasNext()) {
			Entry<Person, List<Pet>> temp = iter2.next();

			if (temp.getKey().getName().equalsIgnoreCase(nameown) && temp.getKey().getAge() == age) {
				map.remove(temp.getKey());

			}

		}
	}

	public void removeAllPet() {

		System.out.println("������ ��� ��������");
		Scanner scRemoveAllPet = new Scanner(System.in);
		String nametype = scRemoveAllPet.nextLine();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();

		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();

			Iterator<Pet> iterPet = temp.getValue().iterator();

			while (iterPet.hasNext()) {
				Pet petdel = iterPet.next();

				if (petdel.getAnimal().equals(nametype)) {
					iterPet.remove();

				}
			}
		}
	}

	public void allClub() {
		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();
		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			System.out.println(temp);
		}
		if (map.isEmpty()) {
			System.out.println("\t��� ��� ���� �������� �����");
		}
	}

	public void exit() {
		System.exit(0);

	}

	public void menu() throws IOException {
		while (true) {
			ZooClub.showMenu();
			Scanner scMenu = new Scanner(System.in);
			int k = scMenu.nextInt();

			switch (k) {
			case (1): {
				addPerson();
				break;
			}
			case (2): {
				addPet();
				break;
			}
			case (3): {
				removePet();
				break;
			}
			case (4): {
				removePerson();
				break;
			}
			case (5): {
				removeAllPet();
				break;
			}
			case (6): {
				allClub();
				break;
			}
			case (7): {
				exit();
				break;
			}
			default:
				System.out.println("���� ������ ������ ");
				return;
			}

		}
	}
}