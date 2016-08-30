package xyz.sangcomz.koreaflu.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Seok-Won on 8/30/16.
 */
data class Owner(val login: String,

                 val id: Long,

                 @SerializedName("avatar_url")
                 val avatarUrl: String)