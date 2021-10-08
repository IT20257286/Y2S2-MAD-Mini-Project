package com.example.carserviceapp;

public class Details {

    /*private String packageNo;
    private String company;
    private String pdetails;*/
    /*private String servicea, serviceb, servicec, serviced, servicee, servicef, serviceg;
    private  String pricea, priceb, pricec, priced, pricee, pricef,priceg;
*/

    private String PackageNo;
    private String PCompany;
    private String PDetails;
    private String Servicea, Serviceb, Servicec, Serviced, Servicee, Servicef, Serviceg;
    private  String Pricea, Priceb, Pricec, Priced, Pricee, Pricef,Priceg;
    private  String Url;


    public Details() {
    }

    public Details(String packageNo, String PCompany, String PDetails, String servicea, String pricea, String serviceb, String priceb, String servicec, String pricec,  String serviced,String priced, String servicee, String pricee, String servicef, String pricef, String serviceg, String priceg) {
        PackageNo = packageNo;
        this.PCompany = PCompany;
        this.PDetails = PDetails;
        Servicea = servicea;
        Pricea = pricea;
        Serviceb = serviceb;
        Priceb = priceb;
        Servicec = servicec;
        Pricec = pricec;
        Serviced = serviced;
        Priced = priced;
        Servicee = servicee;
        Pricee = pricee;
        Servicef = servicef;
        Pricef = pricef;
        Serviceg = serviceg;
        Priceg = priceg;

    }

    public Details(String packageNo, String PCompany, String PDetails, String servicea, String pricea, String serviceb, String priceb, String servicec, String pricec,  String serviced,String priced, String servicee, String pricee, String servicef, String pricef, String serviceg, String priceg, String url){
        PackageNo = packageNo;
        this.PCompany = PCompany;
        this.PDetails = PDetails;
        Servicea = servicea;
        Pricea = pricea;
        Serviceb = serviceb;
        Priceb = priceb;
        Servicec = servicec;
        Pricec = pricec;
        Serviced = serviced;
        Priced = priced;
        Servicee = servicee;
        Pricee = pricee;
        Servicef = servicef;
        Pricef = pricef;
        Serviceg = serviceg;
        Priceg = priceg;

        Url = url;
    }

    public String getPackageNo() {
        return PackageNo;
    }

    public void setPackageNo(String packageNo) {
        PackageNo = packageNo;
    }

    public String getPCompany() {
        return PCompany;
    }

    public void setPCompany(String company) {
        PCompany = company;
    }

    public String getPDetails() {
        return PDetails;
    }

    public void setPDetails(String PDetails) {
        this.PDetails = PDetails;
    }

    public String getServicea() {
        return Servicea;
    }

    public void setServicea(String servicea) {
        Servicea = servicea;
    }

    public String getServiceb() {
        return Serviceb;
    }

    public void setServiceb(String serviceb) {
        Serviceb = serviceb;
    }

    public String getServicec() {
        return Servicec;
    }

    public void setServicec(String servicec) {
        Servicec = servicec;
    }

    public String getServiced() {
        return Serviced;
    }

    public void setServiced(String serviced) {
        Serviced = serviced;
    }

    public String getServicee() {
        return Servicee;
    }

    public void setServicee(String servicee) {
        Servicee = servicee;
    }

    public String getServicef() {
        return Servicef;
    }

    public void setServicef(String servicef) {
        Servicef = servicef;
    }

    public String getServiceg() {
        return Serviceg;
    }

    public void setServiceg(String serviceg) {
        Serviceg = serviceg;
    }

    public String getPricea() {
        return Pricea;
    }

    public void setPricea(String pricea) {
        Pricea = pricea;
    }

    public String getPriceb() {
        return Priceb;
    }

    public void setPriceb(String priceb) {
        Priceb = priceb;
    }

    public String getPricec() {
        return Pricec;
    }

    public void setPricec(String pricec) {
        Pricec = pricec;
    }

    public String getPriced() {
        return Priced;
    }

    public void setPriced(String priced) {
        Priced = priced;
    }

    public String getPricee() {
        return Pricee;
    }

    public void setPricee(String pricee) {
        Pricee = pricee;
    }

    public String getPricef() {
        return Pricef;
    }

    public void setPricef(String pricef) {
        Pricef = pricef;
    }

    public String getPriceg() {
        return Priceg;
    }

    public void setPriceg(String priceg) {
        Priceg = priceg;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    /*public Details(String packageNo, String company, String pdetails){
        this.packageNo = packageNo;
        this.company = company;
        this.pdetails = pdetails;
    }*/

/*public Details(String packageNo, String company, String pdetails, String servicea, String serviceb, String servicec, String serviced, String servicee, String servicef, String serviceg, String pricea, String priceb, String pricec, String priced, String pricee, String pricef, String priceg) {
        this.packageNo = packageNo;
        this.company = company;
        this.pdetails = pdetails;
        this.servicea = servicea;
        this.serviceb = serviceb;
        this.servicec = servicec;
        this.serviced = serviced;
        this.servicee = servicee;
        this.servicef = servicef;
        this.serviceg = serviceg;
        this.pricea = pricea;
        this.priceb = priceb;
        this.pricec = pricec;
        this.priced = priced;
        this.pricee = pricee;
        this.pricef = pricef;
        this.priceg = priceg;
    }*/

    /*public String getPackageNo() {
        return packageNo;
    }

    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }*/

   /* public String getServicea() {
        return servicea;
    }

    public void setServicea(String servicea) {
        this.servicea = servicea;
    }

    public String getServiceb() {
        return serviceb;
    }

    public void setServiceb(String serviceb) {
        this.serviceb = serviceb;
    }

    public String getServicec() {
        return servicec;
    }

    public void setServicec(String servicec) {
        this.servicec = servicec;
    }

    public String getServiced() {
        return serviced;
    }

    public void setServiced(String serviced) {
        this.serviced = serviced;
    }

    public String getServicee() {
        return servicee;
    }

    public void setServicee(String servicee) {
        this.servicee = servicee;
    }

    public String getServicef() {
        return servicef;
    }

    public void setServicef(String servicef) {
        this.servicef = servicef;
    }

    public String getServiceg() {
        return serviceg;
    }

    public void setServiceg(String serviceg) {
        this.serviceg = serviceg;
    }

    public String getPricea() {
        return pricea;
    }

    public void setPricea(String pricea) {
        this.pricea = pricea;
    }

    public String getPriceb() {
        return priceb;
    }

    public void setPriceb(String priceb) {
        this.priceb = priceb;
    }

    public String getPricec() {
        return pricec;
    }

    public void setPricec(String pricec) {
        this.pricec = pricec;
    }

    public String getPriced() {
        return priced;
    }

    public void setPriced(String priced) {
        this.priced = priced;
    }

    public String getPricee() {
        return pricee;
    }

    public void setPricee(String pricee) {
        this.pricee = pricee;
    }

    public String getPricef() {
        return pricef;
    }

    public void setPricef(String pricef) {
        this.pricef = pricef;
    }

    public String getPriceg() {
        return priceg;
    }

    public void setPriceg(String priceg) {
        this.priceg = priceg;
    }
*/
    /*public String getPdetails() {
        return pdetails;
    }

    public void setPdetails(String pdetails) {
        this.pdetails = pdetails;
    }*/
}
