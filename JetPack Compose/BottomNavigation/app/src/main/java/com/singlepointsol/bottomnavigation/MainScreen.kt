package com.singlepointsol.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.singlepointsol.bottomnavigation.pages.HomePage
import com.singlepointsol.bottomnavigation.pages.NotificationPage
import com.singlepointsol.bottomnavigation.pages.SettingsPage

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // List of navigation items

    // Max of 5 working but more thank looking not nice
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home,0),
        NavItem("Notification", Icons.Default.Notifications, 5),
        NavItem("Settings", Icons.Default.Settings, 0)
    )

    // Remember the currently selected index
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (navItem.badgeCount > 0) {
                                        Badge() {
                                            Text(
                                                text = navItem.badgeCount.toString()
                                            )
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = navItem.label
                                )
                            }
                        },
                        label = {
                            Text(
                                text = navItem.label
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier.padding(innerPadding),
            selectedIndex
        )
    }
}


// This is used to go through the page/activity when the icon is clicked
@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int) {
    when (selectedIndex) {
        0 -> HomePage()
        1 -> NotificationPage()
        2 -> SettingsPage()
    }

}
