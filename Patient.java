package application;//package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Patient
{
    // makes Patient object
    protected String id, name, phoneNum, email, emergencyPhone, dob;
    protected String checkupDate, physicalResults, prescribedMeds, healthHistory;
    protected String heartRate, feet, bloodPressure;
    protected String temp, weight, inches;
    protected String gender;
    protected String age;
    protected String insurName, insurGroup, insurNum;
    protected Pharmacy phm;

    public Patient() {
        id = "";
        name = "";
        phoneNum = "";
        email = "";
        emergencyPhone = "";
        dob = "";
        checkupDate = "";
        physicalResults = "";
        prescribedMeds = "";
        healthHistory = "";

        heartRate = "";
        feet = "";
        bloodPressure = "";
        age = "";

        temp = "";
        weight = "";
        inches = "";

        gender = "";

        insurName = "";
        insurGroup = "";
        insurNum = "";
        phm = new Pharmacy();
    }

    public Patient(String name, String phoneNum, String email, String emergencyPhone, String dob,
                    String checkupDate, String physicalResults, String prescribedMeds, String healthHistory,
                    String heartRate, String feet, String bloodPressure, String temp, String weight, String inches,
                    String gender) {
        // strings
        this.id = name + dob;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.emergencyPhone = emergencyPhone;
        this.dob = dob;
        this.checkupDate = checkupDate;
        this.physicalResults = physicalResults;
        this.prescribedMeds = prescribedMeds;
        this.healthHistory = healthHistory;

        // ints
        this.heartRate = heartRate;
        this.feet = feet;
        this.bloodPressure = bloodPressure;
        this.age = age;

        // doubles
        this.temp = temp;
        this.weight = weight;
        this.inches = inches;

        // char
        this.gender = gender;
    }
    

    public Patient(String name, String phoneNum, String email, String emergPhoneNum, String DOB, String gender, String pharmName,
			String pharmAddress,String pharmNum, String insurName, String insurGroupNum, String insurPhoneNum) {
		// TODO Auto-generated constructor stub
    	 this.name = name;
    	 this.phoneNum = phoneNum;
    	 this.email = email;
    	 this.emergencyPhone = emergPhoneNum;
    	 this.dob = DOB;
    	 this.gender = gender;
    	 phm = new Pharmacy(pharmName, pharmAddress, pharmNum);
    	 this.insurName = insurName;
    	 this.insurGroup = insurGroupNum;
    	 this.insurNum = insurPhoneNum;
    	 String patDOB = dob;
         String[] newDOB = patDOB.split("/");
         String[] idName = this.name.split(" ");
         id = idName[0] + idName[1] + newDOB[0]+ newDOB[1] + newDOB[2];
	}

	// setters for all patient variables private
    void setName(String newName) {
        name = newName;
    }

    private void setPhoneNum(String newPhoneNum) {
        phoneNum = newPhoneNum;
    }

    private void setEmergencyPhone(String newEmergencyPhone) {
        emergencyPhone = newEmergencyPhone;
    }

    private void setEmail(String newEmail) {
        email = newEmail;
    }

    private void setDob(String newDob) {
        dob = newDob;
    }

    private void setCheckupHistory(String newCheckupHistory) {
        checkupDate = newCheckupHistory;
    }

    private void setPhysicalResults(String newPhysicalResults) {
        physicalResults = newPhysicalResults;
    }

    private void setPrescribedMeds(String newPrescribedMeds) {
        prescribedMeds = newPrescribedMeds;
    }

    private void setHealthHistory(String newHealthHistory) {
        healthHistory = newHealthHistory;
    }

    private void setHeartRate(String newHeartRate) {
        heartRate = newHeartRate;
    }

    private void setFeet(String newFeet) {
        feet = newFeet;
    }

    private void setBloodPressure(String newBloodPressure) {
        bloodPressure = newBloodPressure;
    }

    private void setAge(String newAge) {
        age = newAge;
    }

    private void setTemp(String newTemp) {
        temp = newTemp;
    }

    private void setWeight(String newWeight) {
        weight = newWeight;
    }

    private void setInches(String newInches) {
        inches = newInches;
    }

    private void setGender(String newGen) {
        gender = newGen;
    }

    // getters for all patient variables
    String getName() {
        return name;
    }

    private String getPhoneNum() {
        return phoneNum;
    }

    private String getEmergencyPhone() {
        return emergencyPhone;
    }

    private String getEmail() {
        return email;
    }

    String getDob() {
        return dob;
    }

    private String getCheckupHistory() {
        return checkupDate;
    }

    private String getPhysicalResults() {
        return physicalResults;
    }

    private String getPrescribedMeds() {
        return prescribedMeds;
    }

    private String getHealthHistory() {
        return healthHistory;
    }

    private String getHeartRate() {
        return heartRate;
    }

    private String getFeet() {
        return feet;
    }

    private String getBloodPressure() {
        return bloodPressure;
    }

    private String getAge() {
        return age;
    }

    private String getTemp() {
        return temp;
    }

    private String getWeight() {
        return weight;
    }

    private String getInches() {
        return inches;
    }

    String getID() {
        return id;
    }

    private String getCurrentDate() {
        //formats date for later use
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    int getFloorAge(String dob) {
        //Patient's DOB
        String patDOB = dob;
        String[] newDOB = patDOB.split("/");
        String patMonth = newDOB[0];
        String patDay = newDOB[1];
        String patYear = newDOB[2];
        //string to int
        int patMonthInt = Integer.parseInt(patMonth);
        int patDayInt = Integer.parseInt(patDay);
        int patYearInt = Integer.parseInt(patYear);

        //Today's Date
        String currDate1 = getCurrentDate();
        String[] currDOB = currDate1.split("/");
        String currMonth = currDOB[0];
        String currDay = currDOB[1];
        String currYear = currDOB[2];
        //string to int
        int currMonthInt = Integer.parseInt(currMonth);
        int currDayInt = Integer.parseInt(currDay);
        int currYearInt = Integer.parseInt(currYear);

        //if patient will be/turned 12 this year
        if (currYearInt - patYearInt == 12) {

            //if patient was born in same month as current month
            if (currMonthInt - patMonthInt == 0) {

                //if patient turned 12 on current date
                if (currDayInt - patDayInt == 0) {
                    return 12;
                }

                //if patient had turned 12 before current date
                else if (currDayInt - patDayInt > 0) {
                    return 12;
                }

                //patient turns 12 after current date
                else {
                    return 11;
                }
            }

            //if patient turned 12 in earlier month
            if (currMonthInt - patMonthInt > 0) {
                return 12;
            }

            //if patient turns 12 after current month
            else {
                return 11;
            }
        } else {
            //if patient was born in same month as current month
            if (currMonthInt - patMonthInt == 0) {

                //if patient bday on current date
                if (currDayInt - patDayInt == 0) {
                    return currYearInt - patYearInt + 1;
                }

                //if patient had turned 12 before current date
                else if (currDayInt - patDayInt > 0) {
                    return currYearInt - patYearInt + 1;
                }
            }
        }
        //if patient bday after current date
        return currYearInt - patYearInt-1;
    }

        public ArrayList<String> addPatientInfo() {
            ArrayList<String> ret = new ArrayList<String>();
            ret.add(name);
            ret.add(phoneNum);
            ret.add(email);
            ret.add(emergencyPhone);
            ret.add(dob);
            ret.add(gender);
            ret.add(phm.getComp());
            ret.add(phm.getAdd());
            ret.add(phm.getNum());
            ret.add(insurName);
            ret.add(insurGroup);
            ret.add(insurNum);
            return ret;
        }
}
