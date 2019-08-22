package com.example.pembelian_buku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private TextView rnama, rqty, rtotal;
    private EditText enama, eqty;
    private Button btn_beli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rnama   = findViewById(R.id.r_nama);
        rqty    = findViewById(R.id.r_qty);
        rtotal  = findViewById(R.id.r_total);
        enama   = findViewById(R.id.inama);
        eqty    = findViewById(R.id.iqty);

        btn_beli = findViewById(R.id.beli);

        btn_beli.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        int harga = 10000;
        if (v.getId() == R.id.beli)
        {

            String inpNama = enama.getText().toString().trim();
            String inpQty  = eqty.getText().toString().trim();

            Integer hqty = toInt(inpQty);

            boolean isInvalidFields = false;

            if (inpQty.length() < 0){

                eqty.setError("Kolom ini harus di isi");
            }
            if (inpNama.length() < 0){

                enama.setError("Kolom ini harus di isi");

            }

            if (!isInvalidFields)
            {
                int jumlah = hqty * harga;
                rnama.setText("Nama Buku: "+inpNama);
                rqty.setText("Jumlah: "+inpQty);
                rtotal.setText("Total Harga: "+ String.valueOf(jumlah));

            }


        }


    }

    private Integer toInt(String str) {
        try {
            return Integer.valueOf(str);
        }catch (Exception we){
            return null;
        }

    }
}
