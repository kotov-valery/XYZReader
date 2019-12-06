package com.example.xyzreader.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

public class ArticleDetailAdapter extends RecyclerView.Adapter<ArticleDetailAdapter.ArticleViewHolder> {
    private String[] articleParagraphs;

    public void setArticleData(String[] paragraphs) {
        articleParagraphs = paragraphs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_detail_paragraph, viewGroup, false);
        ArticleViewHolder viewHolder = new ArticleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
        articleViewHolder.mArticleParagraph.setText(articleParagraphs[i]);
    }

    @Override
    public int getItemCount() {
        return articleParagraphs == null ? 0 : articleParagraphs.length;
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        public TextView mArticleParagraph;

        public ArticleViewHolder(View view) {
            super(view);
            mArticleParagraph = view.findViewById(R.id.article_body_paragraph);
        }
    }
}
