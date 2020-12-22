package pb.pkm.pnm.ac.studentportal;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_MAHASISWA_APP = "spMahasiswaApp";

    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_FOTO = "spFoto";
    public static final String SP_NPM = "spNpm";
    public static final String SP_THAKT = "spThAkt";
    public static final String SP_STATUS = "spStatus";
    public static final String SP_PRODI = "spProdi";
    public static final String SP_KELAS = "spKelas";
    public static final String SP_NOHP = "spNoHP";
    public static final String SP_KOTAASAL = "spKotaAsal";
    public static final String SP_NIK = "spNik";
    public static final String SP_LAHIR = "spLahir";
    public static final String SP_TEMPATLAHIR = "spTempatLahir";
    public static final String SP_JNSKELAMIN = "spJnsKelamin";
    public static final String SP_AGAMA = "spAgama";
    public static final String SP_ALAMATASAL = "spAlamatAsal";
    public static final String SP_ALAMAT = "spAlamat";

    public static final String SP_NAMAAYAH = "spNamaAyah";
    public static final String SP_PEKERJAANAYAH = "spPekerjaanAyah";
    public static final String SP_INSTANSIAYAH = "spInstansiAyah";
    public static final String SP_TTLAYAH = "spTtlAyah";
    public static final String SP_PENDAYAH = "spPendAyah";
    public static final String SP_NIPAYAH = "spNipAyah";
    public static final String SP_PANGKAYAH = "spPangkAyah";
    public static final String SP_PENGHSLAYAH = "spPenghslAyah";
    public static final String SP_NIKAYAH = "spNikAyah";

    public static final String SP_NAMAIBU = "spNamaIbu";
    public static final String SP_PEKERJAANIBU = "spPekerjaanIbu";
    public static final String SP_INSTANSIIBU = "spInstansiIbu";
    public static final String SP_TTLIBU = "spTtlIbu";
    public static final String SP_PENDIBU = "spPendIbu";
    public static final String SP_NIPIBU = "spNipIbu";
    public static final String SP_PANGKIBU = "spPangkIbu";
    public static final String SP_PENGHSLIBU = "spPenghslIbu";
    public static final String SP_NIKIBU = "spNikIbu";

    public static final String SP_NAMAWALI = "spNamaWali";
    public static final String SP_PEKERJAANWALI = "spPekerjaanWali";
    public static final String SP_INSTANSIWALI = "spInstansiWali";
    public static final String SP_TTLWALI = "spTtlWali";
    public static final String SP_PENDWALI = "spPendWali";
    public static final String SP_NIPWALI = "spNipWali";
    public static final String SP_PANGKWALI = "spPangkWali";
    public static final String SP_PENGHSLWALI = "spPenghslWali";
    public static final String SP_NIKWALI = "spNikWali";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_MAHASISWA_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }



    public String getSPLahir(){
        return sp.getString(SP_LAHIR, "");
    }

    public String getSPNamaayah(){
        return sp.getString(SP_NAMAAYAH, "");
    }

    public String getSpNikayah(){
        return sp.getString(SP_NIKAYAH, "");
    }

    public String getSpTtlayah(){
        return sp.getString(SP_TTLAYAH, "");
    }

    public String getSpPendayah(){
        return sp.getString(SP_PENDAYAH, "");
    }

    public String getSpPenghslayah(){
        return sp.getString(SP_PENGHSLAYAH, "");
    }

    public String getSpNipayah(){
        return sp.getString(SP_NIPAYAH, "");
    }

    public String getSpPangkayah(){
        return sp.getString(SP_PANGKAYAH, "");
    }

    public String getSpPekerjaanayah(){
        return sp.getString(SP_PEKERJAANAYAH, "");
    }

    public String getSpInstansiayah(){
        return sp.getString(SP_INSTANSIAYAH, "");
    }

    public String getSpTempatlahir(){
        return sp.getString(SP_TEMPATLAHIR, "");
    }


    public String getSpNamaibu(){
        return sp.getString(SP_NAMAIBU, "");
    }

    public String getSpNikibu(){
        return sp.getString(SP_NIKIBU, "");
    }

    public String getSpTtlibu(){
        return sp.getString(SP_TTLIBU, "");
    }

    public String getSpPendibu(){
        return sp.getString(SP_PENDIBU, "");
    }

    public String getSpPenghslibu(){
        return sp.getString(SP_PENGHSLIBU, "");
    }

    public String getSpNipibu(){
        return sp.getString(SP_NIPIBU, "");
    }

    public String getSpPangkibu(){
        return sp.getString(SP_PANGKIBU, "");
    }

    public String getSpPekerjaanibu(){
        return sp.getString(SP_PEKERJAANIBU, "");
    }

    public String getSpInstansiibu(){
        return sp.getString(SP_INSTANSIIBU, "");
    }


    public String getSpNamawali(){
        return sp.getString(SP_NAMAWALI, "");
    }
    public String getSpPekerjaanwali(){
        return sp.getString(SP_PEKERJAANWALI, "");
    }
    public String getSpInstansiwali(){
        return sp.getString(SP_INSTANSIWALI, "");
    }
    public String getSpTtlwali(){
        return sp.getString(SP_TTLWALI, "");
    }
    public String getSpPendwali(){
        return sp.getString(SP_PENDWALI, "");
    }
    public String getSpNipwali(){
        return sp.getString(SP_NIPWALI, "");
    }
    public String getSpPangkwali(){
        return sp.getString(SP_PANGKWALI, "");
    }
    public String getSpPenghslwali(){
        return sp.getString(SP_PENGHSLWALI, "");
    }
    public String getSpNikwali(){
        return sp.getString(SP_NIKWALI, "");
    }


    public String getSpJnskelamin(){
        return sp.getString(SP_JNSKELAMIN, "");
    }

    public String getSpAgama(){
        return sp.getString(SP_AGAMA, "");
    }

    public String getSpAlamatasal(){
        return sp.getString(SP_ALAMATASAL, "");
    }

    public String getSpAlamat(){
        return sp.getString(SP_ALAMAT, "");
    }

    public String getSPNpm(){
        return sp.getString(SP_NPM, "");
    }

    public String getSPStatus(){
        return sp.getString(SP_STATUS, "");
    }

    public String getSpProdi(){
        return sp.getString(SP_PRODI, "");
    }

    public String getSpKelas(){
        return sp.getString(SP_KELAS, "");
    }

    public String getSpNik(){
        return sp.getString(SP_NIK, "");
    }

    public String getSpNohp(){
        return sp.getString(SP_NOHP, "");
    }

    public String getSpKotaasal(){
        return sp.getString(SP_KOTAASAL, "");
    }

    public String getSpThakt(){
        return sp.getString(SP_THAKT, "");
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }

    public String getSPFoto(){
        return sp.getString(SP_FOTO, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
