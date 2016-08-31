package xyz.sangcomz.koreaflu.flux.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class GitHubUser : RealmObject() {

    @SerializedName("login")
    @Expose
    open var login: String? = null
    @SerializedName("id")
    @Expose
    open var id: Int = 0
    @SerializedName("avatar_url")
    @Expose
    open var avatarUrl: String? = null
    @SerializedName("gravatar_id")
    @Expose
    open var gravatarId: String? = null
    @SerializedName("url")
    @Expose
    open var url: String? = null
    @SerializedName("html_url")
    @Expose
    open var htmlUrl: String? = null
    @SerializedName("followers_url")
    @Expose
    open var followersUrl: String? = null
    @SerializedName("following_url")
    @Expose
    open var followingUrl: String? = null
    @SerializedName("gists_url")
    @Expose
    open var gistsUrl: String? = null
    @SerializedName("starred_url")
    @Expose
    open var starredUrl: String? = null
    @SerializedName("subscriptions_url")
    @Expose
    open var subscriptionsUrl: String? = null
    @SerializedName("organizations_url")
    @Expose
    open var organizationsUrl: String? = null
    @SerializedName("repos_url")
    @Expose
    open var reposUrl: String? = null
    @SerializedName("events_url")
    @Expose
    open var eventsUrl: String? = null
    @SerializedName("received_events_url")
    @Expose
    open var receivedEventsUrl: String? = null
    @SerializedName("type")
    @Expose
    open var type: String? = null
    @SerializedName("site_admin")
    @Expose
    open var isSiteAdmin: Boolean = false
    @SerializedName("name")
    @Expose
    open var name: String? = null
    @SerializedName("company")
    @Expose
    open var company: String? = null
    @SerializedName("blog")
    @Expose
    open var blog: String? = null
    @SerializedName("location")
    @Expose
    open var location: String? = null
    @SerializedName("email")
    @Expose
    open var email: String? = null
    @SerializedName("public_repos")
    @Expose
    open var publicRepos: Int = 0
    @SerializedName("public_gists")
    @Expose
    open var publicGists: Int = 0
    @SerializedName("followers")
    @Expose
    open var followers: Int = 0
    @SerializedName("following")
    @Expose
    open var following: Int = 0
    @SerializedName("created_at")
    @Expose
    open var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    open var updatedAt: String? = null

    override fun toString(): String {
        val sb = StringBuffer("GitHubUser{")
        sb.append("login='").append(login).append('\'')
        sb.append(", id=").append(id)
        sb.append(", avatarUrl='").append(avatarUrl).append('\'')
        sb.append(", gravatarId='").append(gravatarId).append('\'')
        sb.append(", url='").append(url).append('\'')
        sb.append(", htmlUrl='").append(htmlUrl).append('\'')
        sb.append(", followersUrl='").append(followersUrl).append('\'')
        sb.append(", followingUrl='").append(followingUrl).append('\'')
        sb.append(", gistsUrl='").append(gistsUrl).append('\'')
        sb.append(", starredUrl='").append(starredUrl).append('\'')
        sb.append(", subscriptionsUrl='").append(subscriptionsUrl).append('\'')
        sb.append(", organizationsUrl='").append(organizationsUrl).append('\'')
        sb.append(", reposUrl='").append(reposUrl).append('\'')
        sb.append(", eventsUrl='").append(eventsUrl).append('\'')
        sb.append(", receivedEventsUrl='").append(receivedEventsUrl).append('\'')
        sb.append(", type='").append(type).append('\'')
        sb.append(", siteAdmin=").append(isSiteAdmin)
        sb.append(", name='").append(name).append('\'')
        sb.append(", company=").append(company)
        sb.append(", blog='").append(blog).append('\'')
        sb.append(", location='").append(location).append('\'')
        sb.append(", email='").append(email).append('\'')
        sb.append(", publicRepos=").append(publicRepos)
        sb.append(", publicGists=").append(publicGists)
        sb.append(", followers=").append(followers)
        sb.append(", following=").append(following)
        sb.append(", createdAt='").append(createdAt).append('\'')
        sb.append(", updatedAt='").append(updatedAt).append('\'')
        sb.append('}')
        return sb.toString()
    }
}