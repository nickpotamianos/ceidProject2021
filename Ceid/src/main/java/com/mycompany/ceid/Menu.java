package com.mycompany.ceid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Menu {
    private Organization organization;
    private String Name;
    private Donator inDonator;
    private Beneficiary inBeneficiary;
    private Admin inAdmin;
    RequestDonationList listDonations = new RequestDonationList();  // define list with requests

    public Menu(Organization organization) {
        this.organization = organization;
        //arithmos thlefwnou me 10 pshfia
        String reg = "^\\d{10}$";          
        boolean validphonenum = false;
        //eisagwgikh endeiksh
        System.out.println("Welcome to " + organization.getName());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your phone number please. ");
        do {
            String phonenum = scanner.nextLine();
            if (phonenum.matches(reg)) {
                validphonenum = true;
                System.out.println("Your phone number is: " + phonenum);
                checkUser(phonenum);
            } else {
                System.out.println("ERROR! Your phone number should contain 10 digits, please try again!");
            }
        } while (!phonenum);
    }

    public void checkUser(String phonenum) {      // Validation function

        boolean isAdmin = checkIfAdmin(phonenum);
        boolean isDonator = checkIfDonator(phonenum);
        boolean isBeneficiary = checkIfBeneficiary(phonenum);
        if (isAdmin) {
            System.out.println("User is the Admin of the Organization: " + organization.getName());
            System.out.println("Welcome " + organization.getAdmin().getName() + "!");
            inAdmin = organization.getAdmin();
            menuAdmin(inAdmin);
        } else if (isDonator) {
            System.out.println("User is Donator of the Organization: " + organization.getName());
            System.out.println("Welcome " + Name + "!");
            menuDonator(inDonator);
        } else if (isBeneficiary) {
            System.out.println("User is Beneficiary of the Organization: " + organization.getName());
            System.out.println("Welcome " + Name + "!");
            menuBeneficiary(inBeneficiary);
        } else {
            System.out.println("You are not registered, do you want to sign up?");
           System.out.println("1. Sign up");
            System.out.println("0. Exit  ");
            Scanner scanner = new Scanner(System.in);
            boolean validInput = false;
            //epalhtheush eisodou an einai 0 h 1
            do {                                    
                String keyB = scanner.nextLine();
                if (keyB.equals("1") || keyB.equals("2")) {
                    validInput = true;
                    if (keyB.equals("1")) {
                        signUp(phonenum);   //eggrafh neou user sto systhma                             
                    } else {
                        System.exit(1);     //eksodos
                    }
                } else {
                    System.out.println("ERROR! The input is not valid, please try again!");
                }
            } while (!validInput);
        }
    }
    //elegxos an anhkei sthn Admin to thlefwno
    public boolean checkIfAdmin(String phonenum) {                          
        boolean isAdm = false;
        String phone = organization.getAdmin().getPhone();
        if (phone.equals(phonenum)) {
            isAdm = true;
        }
        return isAdm;
    }
    //elegxos an anhkei sthn Donator to thlefwno
    public boolean checkIfDonator(String phonenum) {                           // function that checks if the telelephone belongs to the Donator
        boolean isDonator = false;
        ArrayList<Donator> donatorList = organization.listDonators();    // get the list of the existed Donators from the Organization
        Iterator itr = donatorList.iterator();
        while (itr.hasNext()) {                                            // Iterate the list of Donators from organization
            Donator obj = (Donator) itr.next();
            if (obj.getPhone().equals(phonenum)) {                               // If the phone exist at Donator list then the user is donator
                isDonator = true;
                Name = obj.getName();
                inDonator = obj;                                          // If it is Donator add the object at the private field
            }
        }
        return isDonator;
    }
    //elegxos an anhkei sthn Beneficiary to thlefwno
    public boolean checkIfBeneficiary(String phonenum) {                               
        boolean isBeneficiary = false;
        ArrayList<Beneficiary> beneficiaryList = organization.listBeneficiaries();    // get the list of the existed Beneficiaries from the Organization
        Iterator itr = beneficiaryList.iterator();
        while (itr.hasNext()) {                                                         // Iterate the list of Beneficiaries from organization
            Beneficiary ob = (Beneficiary) itr.next();
            if (ob.getPhone().equals(phonenum)) {                                            // If the phone exist at Beneficiary list then the user is Beneficiary
                isBeneficiary = true;
                Name = ob.getName();
                inBeneficiary = ob;                                                   // If it is Beneficiary add the object at the private field
            }
        }
        return isBeneficiary;
    }


    public void signUp(String phonenum) {
        System.out.println("Select a way to register in, according to your capacity: Admin, Donator or Beneficiary");
        System.out.println("0. Admin");
        System.out.println("1. Donator  ");
        System.out.println("2. Beneficiary  ");
        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;
        int signup = 0;
        // Epalhtheusi an h eisodos einai egkyrh, dhladh  0,1 h 2
        do {                                                  
            String keyB = scanner.nextLine();
            if ((!keyB.equals("0")) && (!keyB.equals("1")) && (!keyB.equals("2"))) {
                System.out.println("ERROR! The input is not valid, please try again!");
                validInput = false;
            } else {

                try {
                    signup = Integer.parseInt(keyB);
                    switch (signup) {
                        case 1:
                            signUpAdmin(phonenum);
                            break;
                        case 2:
                            signUpDonator(phonenum);
                            break;
                        case 3:
                            signUpBeneficiary(phonenum);
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);
    }

    //gia epilogh Admin
    public void signUpAdmin(String phonenum) {                           
        System.out.println("Please enter your name");
        String name = inputName();
        Admin adminNew = new Admin(inputName(),phonenum);
        adminNew.setName(name);
        adminNew.setPhone(phonenum);
        organization.setAdmin(name,phonenum);                                                 
    }
    //gia epilogh Donator
    public void signUpDonator(String phonenum) {                         
        System.out.println("Please enter your name ");
        String name = inputName();
        Donator donatorNew = new Donator(inputName(), phonenum);
        donatorNew.setName(name);
        donatorNew.setPhone(phonenum);
        organization.insertDonator(inputName(),phonenum);                            
        menuDonator(donatorNew);    }
    //gia epilogh Beneficiary
    public void signUpBeneficiary(String phonenum) {                     
        System.out.println("Please enter your name:");
        String name = inputName();
        Beneficiary beneficiaryNew = new Beneficiary(inputName(), phonenum);
        beneficiaryNew.setName(name);
        beneficiaryNew.setPhone(phonenum);
        organization.insertBeneficiary(inputName(), phonenum);                         
        menuBeneficiary(beneficiaryNew);                                      

    }

    public String inputName() {                                
        String name = "";
        String reg2 = "[a-zA-Z]+";
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        do {                                                           
            name = scanner.nextLine();
            if (name.matches(reg2)) {
                validInput = true;
            } else {
                System.out.println("ERROR! The input is not valid, please try again! ");
            }
        } while (!validInput);
        return name;
    }
    //Menu gia Admin
    public void menuAdmin(Admin adminNew) {                                   
        System.out.println("1. View");
        System.out.println("2. Monitor Organization  ");
        System.out.println("3. Back  ");
        System.out.println("4. Logout  ");
        System.out.println("5. Exit  ");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int choice = 0;
        do {
            String keyB = scanner.nextLine();
            if ((!keyB.equals("1")) && (!keyB.equals("2")) && (!keyB.equals("3")) && (!keyB.equals("4")) && (!keyB.equals("5"))) {
                System.out.println("ERROR! The input is not valid, please try again! ");
                validInput = false;
            } else {

                try {
                    choice = Integer.parseInt(keyB);
                    switch (choice) {
                        case 1:
                            admin_view();
                            break;
                        case 2:
                            admin_monitor_organization();
                            break;
                        case 3:
                            back_Menu(organization);                         
                            menuAdmin(inAdmin);
                            break;
                        case 4:
                            System.out.println("Goodbye!");
                            Menu mainPanel = new Menu(organization);          
                            break;
                        case 5:
                            System.exit(1);                           
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);
    }    // Menu gia Donator
    public void menuDonator(Donator donatorNew) {                               
        System.out.println("1. Add Offer");
        System.out.println("2. Show offers  ");
        System.out.println("3. Commit  ");
        System.out.println("4. Back  ");
        System.out.println("5. Logout  ");
        System.out.println("6. Exit  ");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int choice = 0;
        //epalhtheysh an einai h eisodos egkurh
        do {                                                           
            String keyB = scanner.nextLine();
            if ((!keyB.equals("1")) && (!keyB.equals("2")) && (!keyB.equals("3")) && (!keyB.equals("4")) && (!keyB.equals("5")) && (!keyB.equals("6"))) {
                System.out.println("ERROR! The input is not valid, please try again! ");
                validInput = false;
            } else {

                try {
                    choice = Integer.parseInt(keyB);
                    switch (choice) {
                        case 1:                                              
                            donator_addOffer();
                            break;
                        case 2:
                            donator_showOffers();
                            break;
                        case 3:
                            donator_commitOffers();
                            break;
                           case 4:
                            back_Menu(organization);                         
                            menuDonator(inDonator);
                            break;
                        case 5:
                            System.out.println("Goodbye!");
                            Menu mainPanel = new Menu(organization);         
                            break;
                        case 6:
                            System.exit(1);                           
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);
    }
    //Menu gia Beneficiary
    public void menuBeneficiary(Beneficiary beneficiaryNew) {                                  
        System.out.println("1. Add Request");
        System.out.println("2. Show Requests");
        System.out.println("3. Commit  ");
        System.out.println("4. Back  ");
        System.out.println("5. Logout  ");
        System.out.println("6. Exit  ");
        Scanner scanner = new Scanner(System.in);
        boolean validInp = false;
        int choice = 0;
        //epalhtheysh an einai egkurh h eisodos
        do {                                                                      
            String keyB = scanner.nextLine();            if ((!keyB.equals("1")) && (!keyB.equals("2")) && (!keyB.equals("3")) && (!keyB.equals("4")) && (!keyB.equals("5")) && (!keyB.equals("6"))) {
                System.out.println("ERROR! The input is not valid, please try again!");
                validInput = false;
            } else {

                try {
                    choice = Integer.parseInt(keyB);
                    switch (choice) {
                        case 1:
                            beneficiary_addRequest();
                            break;
                        case 2:
                            beneficiary_showRequests();
                            break;
                        case 3:
                           beneficiary_commitRequests();
                            break;
                        case 4:
                            back_Menu(organization);                          
                            menuBeneficiary(inBeneficiary);
                            break;
                        case 5:
                            System.out.println("Goodbye!");
                            Menu mainPanel = new Menu(organization);        
                            break;
                        case 6:
                            System.exit(1);                           
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);
    }

    // Gia offer sthn organization ths donator
    public void donator_addOffer() {                                    
        System.out.println("1. Material");
        System.out.println("2. Services");
        int choice = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        // Epalhtheysh an h eisodos einai egkyrh
        do {                                                            
            String keyB = scanner.nextLine();
            if ((!keyB.equals("1")) && (!keyB.equals("2"))) {
                System.out.println("ERROR! The input is not valid, please try again! ");
                validInput = false;
            } else {
                validInput = true;
                try {
                    choice = Integer.parseInt(keyB);
                    switch (choice) {
                        case 1:                            
                            System.out.println("Materials");
                            organization.listEntities();
                            organization.show_list_Material();                            break;
                        case 2:                         
                            System.out.println("Services");
                            organization.listEntities();
                            organization.show_list_Service();
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);

        String label1 = "";
        String label2 = "";
        if (choice == 1) {                    
            label1 = "quantity";
            label2 = "Material";
        } else {                           
            label1 = "hours";
            label2 = "Service";
        }

        System.out.println("Select ID");
        Scanner scanner2 = new Scanner(System.in);
        String input_id = scanner2.nextLine();
        System.out.println("Select Y or N, if you want to add");
        Scanner scanner3 = new Scanner(System.in);
        String input_answ = scanner3.nextLine();
        if (input_answ.equals("Y")) {
            System.out.println("Please add " + label1 + " of the new " + label2 + "");
            Scanner scanner4 = new Scanner(System.in);
            String input_quantity = scanner4.nextLine();

            RequestDonation rd = organization.getCurrentDonations().get(Integer.parseInt(input_id)); 
            rd.setQuantity(Integer.parseInt(input_quantity));                                        
            listDonations.add(rd);                                                                   
            organization.setCurrentDonations(listDonations);                                        
        } else {
            System.exit(1);
        }
    }

    public void beneficiary_addRequest() {                                                          
        System.out.println("Please select a category that you want to add a request ");
        System.out.println("1. Material");
        System.out.println("2. Services");
        int choice = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        //epalhtheush an h eisodos einai egkyrh
        do {                                                           
            String keyB = scanner.nextLine();
            if ((!keyB.equals("1")) && (!keyB.equals("2"))) {
                System.out.println("ERROR! The input is not valid, please try again! ");
                validInput = false; } else {
                validInput = true;
                try {
                    choice = Integer.parseInt(keyB);
                    switch (choice) {
                        case 1:                           
                            System.out.println(" Materials");
                            organization.listEntities();
                            organization.show_list_Material();
                            break;
                        case 2:                         
                            System.out.println("Services");
                            organization.listEntities();
                            organization.show_list_Service();
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);
    }

    public void beneficiary_showRequests(){                                                 // Beneficiary Show requests
        System.out.println(" Beneficiary has done the following requests "+inBeneficiary.getName()+": ");
        ArrayList<Requests> r  = inBeneficiary.getRequestsList();                           // list of the requests
        for(int i = 0; i<r.size(); i++){
            System.out.println(r.get(i));
        }
    }

    public void admin_view(){
        System.out.println("1. Material");
        System.out.println("2. Services");
        int choice = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        // Epalhtheusi an h eisodos einai egkyrh
        do {                                                            
            String keyB = scanner.nextLine();
            if ((!keyB.equals("1")) && (!keyB.equals("2"))) {
                System.out.println("ERROR! The input is not valid, please try again! ");
                validInput = false;
            } else {
                validInput = true;
                try {
                    choice = Integer.parseInt(keyB);
                    switch (choice) {
                        case 1:                            
                            System.out.println("Materials");
                            organization.listEntities();
                            organization.show_list_Material();
                            break;
                        case 2:                           
                            System.out.println("Services");
                            organization.listEntities();
                            organization.show_list_Service();
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);
    }

    public void admin_monitor_organization() {                                                           // Admin Monitor
        System.out.println("1. List Beneficiaries");
        System.out.println("2. List Donators");
        System.out.println("3. Reset Beneficiaries Lists");
        int choice = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        do {
            String keyB = scanner.nextLine();
            if ((!keyB.equals("1")) && (!keyB.equals("2")) && (!keyB.equals("3"))) {
                System.out.println("ERROR! The input is not valid, please try again!");
                validInput = false;
            } else {
                validInput = true;
                try {
                    choice = Integer.parseInt(keyB);
                    switch (choice) {
                        case 1:                            //   List Beneficiaries
                            System.out.println("---------- Beneficiaries ----------");
                            organization.listBeneficiaries();
                            break;
                        case 2:                            
                            System.out.println("---------- Donators ---------- ");
                            organization.listDonators();
                            break;
                        case 3:                           
                            System.out.println(" All lists are cleared ");
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        } while (!validInput);
    }

    public void back_Menu(Organization organization) {
        this.organization=organization;
    }}

