public class Patient
    {
        //makes Patient object
        Patient p = new Patient();

        protected String name, phoneNum, email, emergencyPhone,emergencyEmail,dob;
        protected String checkupHistory, physicalResults, prescribedMeds, healthHistory;
        protected int heartRate, feet, bloodPressure, age;
        protected double temp, weight, inches;
        protected char gender;


        //setters for all patient variables
        private void setName(String newName)
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

        private void setEmergencyEmail(String newEmergencyEmail)
        {
            emergencyEmail = newEmergencyEmail;
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

        private void setHeartRate(int newHeartRate)
        {
            heartRate = newHeartRate;
        }

        private void setFeet(int newFeet)
        {
            feet = newFeet;
        }

        private void setBloodPressure(int newBloodPressure)
        {
            bloodPressure = newBloodPressure;
        }

        private void setAge (int newAge)
        {
            age = newAge;
        }

        private void setTemp(double newTemp)
        {
            temp = newTemp;
        }

        private void setWeight(double newWeight)
        {
            weight = newWeight;
        }

        private void setInches(double newInches)
        {
            inches = newInches;
        }

        private void setGender(char newGen)
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

        private String getEmergencyEmail()
        {
            return emergencyEmail;
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

        private int getHeartRate()
        {
            return heartRate;
        }

        private int getFeet()
        {
            return feet;
        }

        private int getBloodPressure()
        {
            return bloodPressure;
        }

        private int getAge()
        {
            return age;
        }

        private double getTemp()
        {
            return temp;
        }

        private double getWeight()
        {
            return weight;
        }

        private double getInches()
        {
            return inches;
        }
    }
