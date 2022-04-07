import java.util.ArrayList;

public class Logic {

    public Logic(){

    }


    ArrayList<PhysicalDrive> PHDlist = new ArrayList<PhysicalDrive>();
    ArrayList<PhysicalVolume> PVlist = new ArrayList<PhysicalVolume>();
    ArrayList<LogicalVolume> LVlist = new ArrayList<LogicalVolume>();
    ArrayList<VolumeGroup> VGlist = new ArrayList<VolumeGroup>();

    public ArrayList<PhysicalDrive> getPHD() {
        return PHDlist;
    }

    public ArrayList<PhysicalVolume> getPV() {
        return PVlist;
    }

    public ArrayList<LogicalVolume> getLV() {
        return LVlist;
    }

    public ArrayList<VolumeGroup> getVG() {
        return VGlist;
    }

    public void Runner(String choice){
        if(choice.equals("list-drives")){
            listDrives();
        }
        else if(choice.contains("install-drive")){
            installDrives(choice);
        }
        else if(choice.contains("pvcreate")){
            pvCreate(choice);
        }
        else if(choice.equals("pvlist")){
            pvlist();
        }
        else if(choice.contains("lvcreate")){
            lvcreate(choice);
        }
        else if(choice.equals("lvlist")){
            lvlist();
        }
        else if(choice.contains("vgcreate")){
            vgcreate(choice);
        }
        else if(choice.contains("vgextend")){
            vgextend(choice);
        }
        else if(choice.equals("vglist")){
            vglist();
        }
        else{
            System.out.println("That is not a valid command, please try again.");
        }

    }

    public void installDrives(String input){
        boolean error = false;
        String rest = input.substring(14);
        String name = rest.substring(0, rest.indexOf(" "));
        int size = Integer.parseInt(rest.substring(rest.indexOf(" ") + 1, rest.length()-1));
        PhysicalDrive drive = new PhysicalDrive(name,size);

        for(int i = 0; i < PHDlist.size(); i++){
            if(PHDlist.get(i).getName().equals(name)){
                error = true;
            }
        }

        if(error == false){
            PHDlist.add(drive);
            System.out.println("Drive " + name + " successfully installed");
        }
        else{
            System.out.println();
            System.out.println("This drive has already been installed");
            System.out.println();
        }
    }

    public void listDrives(){
        if(PHDlist.size() == 0){
            System.out.println("You currently have no hard drives installed.");
        }
        else {
            for (int x = 0; x < PHDlist.size(); x++) {
                System.out.print(PHDlist.get(x).getName() + " [" + PHDlist.get(x).getSize() + "G]");
                System.out.println();
            }
        }
    }

    public void pvCreate(String input){
        String rest = input.substring(9);
        String pvName = (rest.substring(0, rest.indexOf(" ")));
        String pdName = (rest.substring(rest.indexOf(" ") + 1));

        if(PHDlist.size() != 0){
            boolean repeated = false;
            for(int i = 0; i < PVlist.size(); i++){
                if(pvName.equals(PVlist.get(i).getName())){
                    repeated = true;
                    System.out.println("There is already a Physical Volume with the name " + pvName);
                    break;
                }
            }
            if(!repeated){
                boolean pdFound = false;
                for(int i = 0; i < PHDlist.size(); i++){
                    if(PHDlist.get(i).getPV() != null && PHDlist.get(i).getName().equals(pdName)){
                        System.out.println("This hard drive is already associated to another Physical Volume");
                        pdFound = true;
                    }
                    if(PHDlist.get(i).getPV() == null && PHDlist.get(i).getName().equals(pdName)){
                        PhysicalVolume newPV = new PhysicalVolume(pvName,PHDlist.get(i));
                        PHDlist.get(i).setPV(newPV);
                        PVlist.add(newPV);
                        System.out.println("Physical Volume " + pvName + " successfully created");
                        pdFound = true;
                    }

                }
                if(!pdFound){
                    System.out.println("There is no hard drive named " + pdName);
                }
            }

        }
        else{
            System.out.println("You currently do not have any Physical Drives installed");
        }
    }

    public void pvlist(){
        if(PVlist.size() == 0){
            System.out.println("There are currently no Physical Volumes created");
        }
        else{
            for(int i = 0; i < PVlist.size(); i++){
                System.out.print(PVlist.get(i).getName() + " : ");
                System.out.print("[" + PVlist.get(i).getHardDrive().getSize()+"G] ");
                if(PVlist.get(i).getVolumeGroup() != null){
                    System.out.print("[" + PVlist.get(i).getVolumeGroup().getName() + "] ");
                }
                System.out.print("[" + PVlist.get(i).getUUID()+ "] ");
                System.out.println();
            }
        }
    }

    public void lvcreate(String input){

    }
    public void lvlist(){

    }
    public void vgcreate(String input){
        String rest  = input.substring(9);
        String vgName = rest.substring(0, rest.indexOf(" "));
        String pvName = rest.substring(rest.indexOf(" "));

        if(PVlist.size() != 0){
            boolean repeated = false;
            for(int i = 0; i < VGlist.size(); i++){
                if(VGlist.get(i).getName().equals(vgName)){
                    repeated = true;
                    System.out.println("There is already a Volume Group with the name " + vgName);
                    break;
                }
            }
            if(!repeated){
                boolean pvFound = false;
                for(int i = 0; i < PHDlist.size(); i++){
                    if(PVlist.get(i).getName().equals(pvName) && PVlist.get(i).getVolumeGroup() != null){
                        System.out.println("This Physical volume is already associated to another Volume Group");
                        pvFound = true;
                    }
                    if(PVlist.get(i).getVolumeGroup() == null && PVlist.get(i).getName().equals(pvName)){
                        VolumeGroup newVG = new VolumeGroup(vgName, PVlist.get(i));
                        VGlist.add(newVG);
                        PVlist.get(i).setVolumeGroup(newVG);
                        System.out.println("Volume group " + vgName + " successfully created");
                        pvFound = true;
                    }
                }
                if(!pvFound){
                    System.out.println("There is no physical volume named " + pvName);
                }

            }
        }
        else{
            System.out.println("You do not have any physical volumes created");
        }
    }
    public void vgextend(String input){

    }
    public void vglist(){

    }
}
