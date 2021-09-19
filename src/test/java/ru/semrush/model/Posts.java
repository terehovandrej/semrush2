package ru.semrush.model;

import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;

public class Posts extends ForwardingSet<PostData> {
    public Set<PostData> delegate;

    public Posts(Posts posts) {
        this.delegate = new HashSet<PostData>(posts.delegate);
    }

    public Posts() {
        this.delegate = new HashSet<PostData>();
    }

    @Override
    protected Set<PostData> delegate() {
        return delegate;
    }

}
