import java.util.LinkedList;

public class VM extends ComputerCluster {
  private int VmId;
  private int VMCPU;
  private int VMRAM;
  private String VMSoftware;
  private int Allocated_CPU=0;
  private int Allocated_RAM=0;

  LinkedList<Programs> ExecutingProjects = new LinkedList<>();

  public VM(int VmId, int VMCPU, int VMRAM, String VMSoftware) {
    this.VmId = VmId;
    this.VMCPU = VMCPU;
    this.VMRAM = VMRAM;
    this.VMSoftware = VMSoftware;

  }

  public int getVmId() {
    return VmId;
  }

  public void setVmId(int vmId) {
    VmId = vmId;
  }

  public int getVMCPU() {
    return VMCPU;
  }

  public void setVMCPU(int vMCPU) {
    VMCPU = vMCPU;
  }

  public int getVMRAM() {
    return VMRAM;
  }

  public void setVMRAM(int vMRAM) {
    VMRAM = vMRAM;
  }

  public String getVMSoftware() {
    return VMSoftware;
  }

  public void setVMSoftware(String vMSoftware) {
    VMSoftware = vMSoftware;
  }

  public int getAllocated_CPU() {
    return Allocated_CPU;
  }

  public void setAllocated_CPU(int allocated_CPU) {
    Allocated_CPU = allocated_CPU;
  }

  public int getAllocated_RAM() {
    return Allocated_RAM;
  }

  public void setAllocated_RAM(int allocated_RAM) {
    Allocated_RAM = allocated_RAM;
  }

}
