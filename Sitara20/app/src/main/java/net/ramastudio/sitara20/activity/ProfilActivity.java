package net.ramastudio.sitara20.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.ramastudio.sitara20.BaseActivity;
import net.ramastudio.sitara20.R;
import net.ramastudio.sitara20.adapter.AdapterUserItem;
import net.ramastudio.sitara20.model.Session;
import net.ramastudio.sitara20.model.User;
import net.ramastudio.sitara20.model.UserItem;
import net.ramastudio.sitara20.utils.Pref;
import net.ramastudio.sitara20.utils.api.ApiService;
import net.ramastudio.sitara20.utils.api.UtilsApi;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends BaseActivity {


    private final ApiService mApiService;
    @BindView(R.id.rv_profil)
    RecyclerView rvProfil;

    private AdapterUserItem adapterUserItem;

    ArrayList<UserItem> userItem = new ArrayList<>();
    public ProfilActivity() {
        this.mApiService = UtilsApi.getAPIService();
    }

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setTitle("Para Pihak");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapterUserItem = new AdapterUserItem(userItem);
        rvProfil = (RecyclerView) findViewById(R.id.rv_profil);
        rvProfil.setLayoutManager(new LinearLayoutManager(this));
        rvProfil.setAdapter(adapterUserItem);
        session = Pref.getSession();
        setProfil();
    }

    private void setProfil() {
        showLoading();
        UtilsApi.getAPIService().getUser(session.idperkara).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                hideLoading();
                if(response.isSuccessful()){
                    userItem.clear();
                    userItem.addAll(response.body().getUser());
                    adapterUserItem.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                hideLoading();
                toast("Gagal memuat data");
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}