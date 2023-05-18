import java.util.ArrayList;
import java.util.Random;

public class CLI {

  ArrayList<VM> VMs = new ArrayList<>();
  public int REMAIN_CPU = ComputerCluster.Max_CPU;
  public int REMAIN_RAM = ComputerCluster.Max_RAM;
  public int REMAIN_SSD = ComputerCluster.Max_SSD;
  public int REMAIN_GPU = ComputerCluster.Max_GPU;
  public int REMAIN_Ethernet = ComputerCluster.Max_Ethernet;

  // VM
  public void createVm(int VMCPU, int VMRAM, String VMSoftware) {
    int VmID = createRandomInt();

    VM tempVm = new VM(VmID, VMCPU, VMRAM, VMSoftware);
    VMs.add(tempVm);
    updateremaining(VMCPU, VMRAM, 0, 0, 0);

  }

  // PlainVM
  public void createPlainVm(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD) {
    int VmID = createRandomInt();

    PlainVM tempVm = new PlainVM(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD);
    VMs.add(tempVm);
    updateremaining(VMCPU, VMRAM, PlainSSD, 0, 0);

  }

  // VmGPU
  public void createVmGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VmGPU) {
    int VmID = createRandomInt();

    VmGPU tempVm = new VmGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, VmGPU);
    VMs.add(tempVm);
    updateremaining(VMCPU, VMRAM, PlainSSD, 0, VmGPU);

  }

  // VmNetworked
  public void createVmNetworked(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth) {
    int VmID = createRandomInt();

    VMNetworked tempVm = new VMNetworked(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth);
    VMs.add(tempVm);
    updateremaining(VMCPU, VMRAM, PlainSSD, Bandwidth, 0);

  }

  // VmNetworkedGPU
  public void createVmNetworkedGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int VMGPU) {
    int VmID = createRandomInt();

    VMNetworkedGPU tempVm = new VMNetworkedGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth, VMGPU);
    VMs.add(tempVm);
    updateremaining(VMCPU, VMRAM, PlainSSD, Bandwidth, VMGPU);

  }

  public int createRandomInt() {

    Random random = new Random();
    int randomInt = 0;
    int k = 1;

    while (k == 1) {
      randomInt = random.nextInt(Integer.MAX_VALUE - 2147483000) + 1; /* ώστε το VMid να μην είναι πολύ μεγάλο */
      k = -1;
      for (int i = 0; i < VMs.size(); i++) {
        if (randomInt == VMs.get(i).getVmId()) {
          k = 1;
          break;
        }
      }
      if (k == -1) {
        break;
      }

    }

    return randomInt;

  }

  public void updateremaining(int VMCPU, int VMRAM, int PlainSSD, int Bandwidth, int gpu) {
    REMAIN_CPU -= VMCPU;
    REMAIN_RAM -= VMRAM;
    REMAIN_SSD -= PlainSSD;
    REMAIN_Ethernet -= Bandwidth;
    REMAIN_GPU -= gpu;
  }

}
