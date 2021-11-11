package application;
public class Patient
{
    //makes Patient object
    protected String id,name, phoneNum, email, emergencyPhone,dob;
    protected String checkupHistory, physicalResults, prescribedMeds, healthHistory;
    protected String heartRate, feet, bloodPressure;
    protected String temp, weight, inches;
    protected String gender;
    protected String age;

    public Patient()
    {
    	id = "";
        name = "";
        phoneNum = "";
        email = "";
        emergencyPhone = "";
        dob = "";
        checkupHistory = "";
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
    }
    private Patient(String name,String phoneNum,String email,String emergencyPhone,
                            String dob,String checkupHistory,String physicalResults,String prescribedMeds,
                            String healthHistory, String heartRate, String feet, String bloodPressure, String temp,
                            String weight, String inches, String gender)
    {
        //strings
    	this.id = name+dob;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.emergencyPhone = emergencyPhone;
        this.dob = dob;
        this.checkupHistory = checkupHistory;
        this.physicalResults = physicalResults;
        this.prescribedMeds = prescribedMeds;
        this.healthHistory = healthHistory;

        //ints
        this.heartRate = heartRate;
        this.feet = feet;
        this.bloodPressure = bloodPressure;
        this.age = age;

        //doubles
        this.temp = temp;
        this.weight = weight;
        this.inches = inches;

        //char
        this.gender = gender;
    }
    public Patient(String name, String phoneNum, String email, String emergencyNum,String dob, String gender) {
    	this.name = name;
    	this.phoneNum = phoneNum;
    	this.email = email;
    	this.emergencyPhone = emergencyNum;
    	this.dob = dob;
    	this.gender = gender;
    }
    //setters for all patient variablesprivate 
    void setID(String newName)
    {
        name = newName;
    }
    void setName(String newName)
    {
        name = newName;
    }

    private void setPhoneNum(String newPhoneNum)
    {
        phoneNum = newPhoneNum;
    }

    private void setEmergencyPhone(String newEmergencyPhone)
    {
        emergencyPhone = newEmergencyPhone;
    }

    private void setEmail(String newEmail)
    {
        email = newEmail;
    }

    private void setDob(String newDob)
    {
        dob = newDob;
    }

    private void setCheckupHistory(String newCheckupHistory)
    {
        checkupHistory = newCheckupHistory;
    }

    private void setPhysicalResults (String newPhysicalResults)
    {
        physicalResults = newPhysicalResults;
    }

    private void setPrescribedMeds(String newPrescribedMeds)
    {
        prescribedMeds = newPrescribedMeds;
    }

    private void setHealthHistory(String newHealthHistory)
    {
        healthHistory = newHealthHistory;
    }

    private void setHeartRate(String newHeartRate)
    {
        heartRate = newHeartRate;
    }

    private void setFeet(String newFeet)
    {
        feet = newFeet;
    }

    private void setBloodPressure(String newBloodPressure)
    {
        bloodPressure = newBloodPressure;
    }

    private void setAge (String newAge)
    {
        age = newAge;
    }

    private void setTemp(String newTemp)
    {
        temp = newTemp;
    }

    private void setWeight(String newWeight)
    {
        weight = newWeight;
    }

    private void setInches(String newInches)
    {
        inches = newInches;
    }

    private void setGender(String newGen)
    {
        gender = newGen;
    }


    //getters for all patient variables
    private String getName()
    {
        return name;
    }

    private String getPhoneNum()
    {
        return phoneNum;
    }

    private String getEmergencyPhone()
    {
        return emergencyPhone;
    }

    private String getEmail()
    {
        return email;
    }

    private String getDob()
    {
        return dob;
    }

    private String getCheckupHistory()
    {
        return checkupHistory;
    }

    private String getPhysicalResults()
    {
        return physicalResults;
    }

    private String getPrescribedMeds()
    {
        return prescribedMeds;
    }

    private String getHealthHistory()
    {
        return healthHistory;
    }

    private String getHeartRate()
    {
        return heartRate;
    }

    private String getFeet()
    {
        return feet;
    }

    private String getBloodPressure()
    {
        return bloodPressure;
    }

    private String getAge()
    {
        return age;
    }

    private String getTemp()
    {
        return temp;
    }

    private String getWeight()
    {
        return weight;
    }

    private String getInches()
    {
        return inches;
    }
	public void newAccount(String name, String DOB, String email, String phone, String emgPhone) {
		this.name = name;
		this.dob = DOB;
		this.email = email;
		this.phoneNum = phone;
		this.emergencyPhone = emgPhone;
		
	}
	private int getFloorAge() {
		//Calculate age. floor. Use "01/02/2000". Parser string to int. 
		return 0;
	}
}
