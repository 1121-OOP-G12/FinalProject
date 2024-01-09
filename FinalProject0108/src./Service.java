import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item keyA = new Item("key", 10);
        Item keyB = new Item("key", 5);
        Item dehumidifierA = new Item("dehumidifier", 3);
        Item dehumidifierB = new Item("dehumidifier", 1);
        
        Student stu1 = new Student(111203045, "Tina", "dorm1");
		Student stu2 = new Student(112304045, "Kate", "dorm2");
		Student stu3 = new Student(111102531, "Jack", "dorm1");
		Student stu4 = new Student(111203045, "York", "dorm3");
		Student stu5 = new Student(111203541, "Monica", "dorm3");
		
		DormServiceA a1 = new DormServiceA(stu1,  (Math.random()*10)+1);
		DormServiceA a2 = new DormServiceA(stu2,  (Math.random()*10)+1);
		DormServiceA a3 = new DormServiceA(stu3,  (Math.random()*10)+1);
		DormServiceB b1 = new DormServiceB(stu4,  (Math.random()*10)+1);
		DormServiceB b2 = new DormServiceB(stu5,  (Math.random()*10)+1);
		
		a1.enroll(stu1);
		a2.enroll(stu2);
		a3.enroll(stu3);
		b1.borrowItem(dehumidifierB);
		b2.bookDiscussionRoom(1, stu5);

        System.out.println("Welcome to Dormitory Service System! We're glad to have you on board.");
        System.out.println("Please enter your Student ID, Name, and the dormitory where you reside.");
        System.out.println("(ex. 109305012 Chirstina dorm1)");

        int id, service, func, use;
        String name, dorm;

        id = sc.nextInt();
        name = sc.next();
        dorm = sc.next();
        Student stu = new Student(id, name, dorm);
        do {
            
            if (dorm.equalsIgnoreCase("dorm1") || dorm.equalsIgnoreCase("dorm2")) {
                DormServiceA a = new DormServiceA(stu, (Math.random() * 10) + 1);
                System.out.println("如需冷氣加值服務，請按1；如需物品借用服務，請按2; 如需揪團上山服務，請按3");
                System.out.print("請輸入所需服務：");
                service = sc.nextInt();

                if (service == 1) {
                    System.out.print("顯示餘額，請按1；加值服務，請按2: ");
                    func = sc.nextInt();
                    if (func == 1) {
                        a.info();
                    } else if (func == 2) {
                        int fee;
                        System.out.print("請輸入儲值金額： ");
                        fee = sc.nextInt();
                        a.addAirConRV(fee);
                    }
                } else if (service == 2) {
                    System.out.print("鑰匙借還，請按1；除濕機借還，請按2: ");
                    func = sc.nextInt();
                    if (func == 1) {
                        System.out.print("借用，請按1；歸還，請按2: ");
                        use = sc.nextInt();
                        if (use == 1) {
                            if (keyA.getAvailableAmount() > 0) {
                                a.borrowItem(keyA);
                                System.out.println("借用成功 ٩(˃̶͈̀௰˂̶͈́)و，請儘速歸還喔～");
                            } else {
                                System.out.println("被借光了qqqq，請稍後再借");
                            }

                        } else if (use == 2) {
                            a.giveItemback(keyA);
                            System.out.println("歸還成功 ٩(˃̶͈̀௰˂̶͈́)و，感謝您的配合～");
                        }

                    } else if (func == 2) {
                        System.out.print("借用，請按1；歸還，請按2: ");
                        use = sc.nextInt();
                        if (use == 1) {
                            if (dehumidifierA.getAvailableAmount() > 0) {
                                a.borrowItem(dehumidifierA);
                                System.out.println("借用成功٩(˃̶͈̀௰˂̶͈́)و，請於一週內歸還喔～");
                            } else {
                                System.out.println("被借光了qqqq，請稍後再借");
                            }
                        } else if (use == 2) {
                            a.giveItemback(dehumidifierA);
                            System.out.println("歸還成功 ٩(˃̶͈̀௰˂̶͈́)و，感謝您的配合～");
                        }
                    }

                } else if (service == 3) {
                    System.out.print("想要跟團上山？請按1;等待太久想退出？請按2");
                    func = sc.nextInt();
                    if (func == 1) {
                        System.out.println(stu.getName() + " 您好，您以成功加入揪團行列，目前團中已有 " + DormServiceA.getGroups().size() + " 人登記揪團。");
                        a.enroll(stu);
                        if (DormServiceA.getGroups().size() == 4) {
                            System.out.print("揪團成功！您的團員有： ");
                            for (Student student : DormServiceA.getGroups()) {
                                System.out.print(student.getID() + student.getName() + " ");
                            }
                            System.out.println("請於五分鐘內前往行政大樓集合，準備上山～");

                            // 清空揪團列表，以便下次使用
                            DormServiceA.getGroups().clear();
                        } else {
                            System.out.println("請稍候，人到齊後將立刻通知您。");
                        }
                    } else if (func == 2) {
                        a.drop(stu);
                        System.out.println("退出成功，歡迎下次使用本服務。");
                        break; // 退出迴圈
                    }
                }
            } else if (dorm.equalsIgnoreCase("dorm3")) {
                DormServiceB b = new DormServiceB(stu, (Math.random() * 10) + 1);
                System.out.println("如需冷氣加值服務，請按1；如需物品借用服務，請按2; 如需借用討論室，請按3");
                System.out.print("請輸入所需服務：");
                service = sc.nextInt();

                if (service == 1) {
                    System.out.print("顯示餘額，請按1；加值服務，請按2: ");
                    func = sc.nextInt();
                    if (func == 1) {
                        b.info();
                    } else if (func == 2) {
                        int fee;
                        System.out.print("請輸入儲值金額： ");
                        fee = sc.nextInt();
                        b.addAirConRV(fee);
                    }
                } else if (service == 2) {
                    System.out.print("鑰匙借還，請按1；除濕機借還，請按2: ");
                    func = sc.nextInt();
                    if (func == 1) {
                        System.out.print("借用，請按1；歸還，請按2: ");
                        use = sc.nextInt();
                        if (use == 1) {
                            if (keyB.getAvailableAmount() > 0) {
                                b.borrowItem(keyB);
                                System.out.println("借用成功 ٩(˃̶͈̀௰˂̶͈́)و，請儘速歸還喔～");
                            } else {
                                System.out.println("被借光了qqqq，請稍後再借");
                            }

                        } else if (use == 2) {
                            b.giveItemback(keyB);
                            System.out.println("歸還成功 ٩(˃̶͈̀௰˂̶͈́)و，感謝您的配合～");
                        }

                    } else if (func == 2) {
                        System.out.print("借用，請按1；歸還，請按2: ");
                        use = sc.nextInt();
                        if (use == 1) {
                            if (dehumidifierB.getAvailableAmount() > 0) {
                                b.borrowItem(dehumidifierB);
                                System.out.println("借用成功٩(˃̶͈̀௰˂̶͈́)و，請於一週內歸還喔～");
                            } else {
                                System.out.println("被借光了qqqq，請稍後再借");
                            }
                        } else if (use == 2) {
                            b.giveItemback(dehumidifierB);
                            System.out.println("歸還成功 ٩(˃̶͈̀௰˂̶͈́)و，感謝您的配合～");
                        }
                    }

                } else if (service == 3) {
                    System.out.print("借用討論室，請按1；使用完畢，請按2: ");
                    func = sc.nextInt();
                    System.out.print("\n請輸入欲借用的討論室號碼：");
                    use = sc.nextInt();

                    if (func == 1) {
                        b.bookDiscussionRoom(use, stu);

                    } else if (func == 2) {
                        b.leaveDiscussionRoom(use, stu);
                    }
                }
            }

            System.out.println("是否需要使用其他服務呢？  (Y/N)");
        } while (sc.next().equalsIgnoreCase("Y"));

        System.out.println("謝謝您，下次見，掰掰～");

        // close the scanner
        sc.close();
    }
}
