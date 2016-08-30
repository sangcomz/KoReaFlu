package xyz.sangcomz.koreaflu.flux.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitHubUser {

    @SerializedName("login")
    @Expose
    var login: String? = null
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null
    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null
    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null
    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null
    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null
    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null
    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null
    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("site_admin")
    @Expose
    var isSiteAdmin: Boolean = false
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("company")
    @Expose
    var company: Any? = null
    @SerializedName("blog")
    @Expose
    var blog: String? = null
    @SerializedName("location")
    @Expose
    var location: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("public_repos")
    @Expose
    var publicRepos: Int = 0
    @SerializedName("public_gists")
    @Expose
    var publicGists: Int = 0
    @SerializedName("followers")
    @Expose
    var followers: Int = 0
    @SerializedName("following")
    @Expose
    var following: Int = 0
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

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