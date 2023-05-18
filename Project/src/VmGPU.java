public class VmGPU extends PlainVM {
  private int VMGPU;

  public VmGPU(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VMGPU) {
    super(VmId, VMCPU, VMRAM, VMSoftware, PlainSSD);

    this.VMGPU = VMGPU;

  }

  public int getVMGPU() {
    return VMGPU;
  }

  public void setVMGPU(int vMGPU) {
    VMGPU = vMGPU;
  }
}
