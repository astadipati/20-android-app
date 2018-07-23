package net.ramastudio.sitara20.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.ramastudio.sitara20.R;
import net.ramastudio.sitara20.adapter.Adapter_Profil;
import net.ramastudio.sitara20.utils.SharedPrefManager;
import net.ramastudio.sitara20.utils.api.ApiService;
import net.ramastudio.sitara20.utils.api.UtilsApi;

import butterknife.BindView;

public class ProfilActivity extends AppCompatActivity {

    SharedPrefManager spMgr;

    private final ApiService mApiService;
    @BindView(R.id.rv_profil)RecyclerView rvProfil;

    private Adapter_Profil adapter_profil;
    public ProfilActivity() {
        this.mApiService = UtilsApi.getAPIService();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setTitle("Para Pihak");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spMgr = new SharedPrefManager(getApplicationContext());

        rvProfil = (RecyclerView) findViewById(R.id.rv_profil);
        rvProfil.setLayoutManager(new LinearLayoutManager(this));

        setProfil(spMgr.getSPIDPerkara());
    }

    private void setProfil() {
        ApiService api =
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
