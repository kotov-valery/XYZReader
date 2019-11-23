package com.example.xyzreader.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ItemsContract;

/**
 * An activity representing a list of Articles. This activity has different presentations for
 * handset and tablet-size devices. On handsets, the activity presents a list of items, which when
 * touched, lead to a {@link ArticleDetailActivity} representing item details. On tablets, the
 * activity presents a grid of items as cards.
 */
public class ArticleListActivity extends AppCompatActivity
        implements ArticleListFragment.OnArticleClickListener {

    private static final String TAG = ArticleListActivity.class.toString();

    private boolean mTwoPane = false;

    private final static long INVALID = -1;
    private long mItemId = INVALID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        mTwoPane = getResources().getBoolean(R.bool.two_pane_view_enabled);
    }

    @Override
    public void onArticleSelected(long id) {
        if (mTwoPane) {
            ArticleDetailFragment article = ArticleDetailFragment.newInstance(id);

            if (mItemId == INVALID) {
                getFragmentManager().beginTransaction()
                        .add(R.id.article_container, article)
                        .commit();
            } else {
                getFragmentManager().beginTransaction()
                        .replace(R.id.article_container, article)
                        .commit();
            }
            mItemId = id;
        } else {
            Uri uri = ItemsContract.Items.buildItemUri(id);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }
}
