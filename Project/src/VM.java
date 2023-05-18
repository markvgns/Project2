public class VM extends ComputerCluster {
  private int VmId;
  private int VMCPU;
  private int VMRAM;
  private String VMSoftware;

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

}
