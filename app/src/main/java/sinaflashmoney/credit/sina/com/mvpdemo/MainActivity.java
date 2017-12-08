package sinaflashmoney.credit.sina.com.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import sinaflashmoney.credit.sina.com.mvpdemo.service.entity.Book;
import sinaflashmoney.credit.sina.com.mvpdemo.service.presenter.BookPresenter;
import sinaflashmoney.credit.sina.com.mvpdemo.service.view.BookView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;
    private BookPresenter bookPresent=new BookPresenter(this);
    private BookView bookView=new BookView() {
        @Override
        public void onSuccess(Book mBook) {
            tv.setText(mBook.toString());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              bookPresent.getSearchBooks("金瓶梅",null,0,1);
            }
        });
        bookPresent.onCreat();
        bookPresent.attachView(bookView);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bookPresent.onStop();
    }
}
