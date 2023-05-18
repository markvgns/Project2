import java.util.ArrayList;
import java.util.Random;

public class CLI {

  ArrayList<VM> VMs = new ArrayList<>();
  int numofVms = 0;
  public int VmID;

  // VM
  public void createVm(int VMCPU, int VMRAM, String VMSoftware) {
    int VmID = createRandomInt();
    VM tempVm = new VM(VmID, VMCPU, VMRAM, VMSoftware);
    VMs.add(tempVm);
    numofVms++;
  }

  // PlainVM
  public void createPlainVm(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD) {
    int VmID = createRandomInt();
    PlainVM tempVm = new PlainVM(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD);
    VMs.add(tempVm);
    numofVms++;
  }

  // VmGPU
  public void createVmGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VmGPU) {
    int VmID = createRandomInt();
    VmGPU tempVm = new VmGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, VmGPU);
    VMs.add(tempVm);
    numofVms++;
  }

  // VmNetworked
  public void createVmNetworked(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth) {
    int VmID = createRandomInt();
    VMNetworked tempVm = new VMNetworked(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth);
    VMs.add(tempVm);
    numofVms++;

  }

  // VmNetworkedGPU
  public void createVmNetworkedGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int VMGPU) {
    int VmID = createRandomInt();
    VMNetworkedGPU tempVm = new VMNetworkedGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth, VMGPU);
    VMs.add(tempVm);
    numofVms++;
  }

  public int createRandomInt()
  {
    for(int i=0; i<numofVms; i++)
    {
        if(VmID == VMs.get(i).getID()) /*-------> sou bgazei error epeidh den exoume ftiaxei getter gia to id se kathe class ton VMs*/
        {
            break;
        }
        else 
        {
            Random random = new Random();
            int randomInt = random.nextInt(Integer.MAX_VALUE -1) +1;
            return randomInt;

        }
    }
    
  }

}
