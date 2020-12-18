package gohryt.sapphire.navigation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import gohryt.sapphire.Activity
import kotlin.system.exitProcess

class Navigator(private var activity: AppCompatActivity) {
    private var addedRoutes: Array<Route> = arrayOf()
    private var current: Route? = null
    fun add(vararg routes: Route) {
        for (route in routes) {
            addedRoutes += route
        }
    }
    fun start(address: String) {
        var found = false
        for (r in addedRoutes) {
            if (r.address == address) {
                found = true
                if (r.type == Types.SPECIFIC || current?.type == Types.SPECIFIC) {
                    activity.setContentView(r.action(activity))
                }
                current = r
            }
        }
        if (!found) {
            Toast.makeText(activity, Activity.errors!!.addressNotFound, Toast.LENGTH_SHORT).show()
            exitProcess(1)
        }
    }
    fun move(address: String) {
        var found = false
        for (r in addedRoutes) {
            if (r.address == address) {
                found = true
                if (r.type == Types.SPECIFIC || current?.type == Types.SPECIFIC) {
                    activity.setContentView(r.action(activity))
                }
                current = r
            }
        }
        if (!found) {
            Toast.makeText(activity, Activity.errors!!.addressNotFound, Toast.LENGTH_SHORT).show()
            exitProcess(1)
        }
    }
}