package ibotntest;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class OpenWifi extends UiAutomatorTestCase {

	public static void main() {

		UiDevice.getInstance().pressHome();
		UiDevice.getInstance().pressHome();
		UiDevice.getInstance().pressBack();
	}

	boolean openwifiseting() throws UiObjectNotFoundException {

		UiObject openwifiap = new UiObject(new UiSelector().descriptionContains("设置"));
		openwifiap.clickAndWaitForNewWindow();
		assertEquals(true, true);
		assertEquals(getUiDevice(), openwifiap);
		assertEquals("设置", openwifiap);
		assertEquals("查找设置菜单成功", "设置", openwifiap);
		return false;

	}

	@Override
	public UiDevice getUiDevice() {
		// TODO Auto-generated method stub
		return super.getUiDevice();
	}

}
