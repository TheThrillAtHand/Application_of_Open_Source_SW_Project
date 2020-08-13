// 작성자 : 2016039002 박성진
// 설  명 : PostInfo class listener

package com.example.thethrillathand;

import com.example.thethrillathand.PostInfo;

public interface OnPostListener {
    void onDelete(PostInfo postInfo);
    void onModify();
}
