import java.util.ArrayList;
import java.util.Random;

public class CLI {

  ArrayList<VM> VMs = new ArrayList<>();

  // VM
  public void createVm(int VMCPU, int VMRAM, String VMSoftware) {
    int VmID = createRandomInt();
    
    VM tempVm = new VM(VmID, VMCPU, VMRAM, VMSoftware);
    VMs.add(tempVm);

  }

  // PlainVM
  public void createPlainVm(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD) {
    int VmID = createRandomInt();
   
    PlainVM tempVm = new PlainVM(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD);
    VMs.add(tempVm);

  }

  // VmGPU
  public void createVmGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VmGPU) {
    int VmID = createRandomInt();
   
    VmGPU tempVm = new VmGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, VmGPU);
    VMs.add(tempVm);

  }

  // VmNetworked
  public void createVmNetworked(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth) {
    int VmID = createRandomInt();
    
    VMNetworked tempVm = new VMNetworked(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth);
    VMs.add(tempVm);

  }

  // VmNetworkedGPU
  public void createVmNetworkedGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int VMGPU) {
    int VmID = createRandomInt();
    
    VMNetworkedGPU tempVm = new VMNetworkedGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth, VMGPU);
    VMs.add(tempVm);

  }

  public int createRandomInt() 
  {
    Random random = new Random();
    int randomInt;
    int k=1;

    while(k==1)
    {
        randomInt = random.nextInt(Integer.MAX_VALUE -1) +1; /*--------> allaxe to 1 se megalo airtho */
        k =-1;
        for(int i=0; i<VMs.size(); i++)
        {
            if(randomInt == VMs.get(i).getID())
            {
                k = 1;
                break;
            }

        }
      
        if(k == -1)
        {
            break;
        }

    }
    return randomInt;
  }

}
