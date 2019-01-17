//package placeutil;
class Place {
    public String name;
    public int population;
    public String classification;
    public Place(String name,String classification){
        this.name = name;
        this.classification = classification;
        // this.numberOfschools = numberOfschools;
    }
    public String getPlace(){
        return name;
    }
    public String getClassification(){
        return classification;
    }
}

