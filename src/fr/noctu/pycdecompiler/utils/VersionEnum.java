package fr.noctu.pycdecompiler.utils;

public enum VersionEnum {
    v15(20121),
    v16(50420),
    v20(50823),
    v21(60202),
    v22(60717),
    v23_a0(62011),
    v23_a0b(62021),
    v24_a0(62041),
    v24_a3(62051),
    v24_b1(62061),
    v25_a0(62071),
    v25_a0b(62081),
    v25_a0c(62091),
    v25_a0d(62092),
    v25_b3(62101),
    v25_b3b(62111),
    v25_c1(62121),
    v25_c2(62131),
    v26_a0(62151),
    v26_a1(62161),
    v27_a0(62171),
    v27_a0b(62181),
    v27_a0c(62191),
    v27_a0d(62201),
    v27_a0e(62211),
    UNKNOWN_VERSION(-1);

    private final int versionValue;
    VersionEnum(int version){
        this.versionValue = version;
    }

    public int getVersionValue(){
        return versionValue;
    }

    @Override
    public String toString() {
        return "Version: " + name() + " | value: " + getVersionValue();
    }

    //STATICS//

    public static VersionEnum getVersionByInt(int version){
        for (VersionEnum versionEnum : VersionEnum.values()){
            if(versionEnum.versionValue == version)
                return versionEnum;
        }
        return VersionEnum.UNKNOWN_VERSION;
    }
}
