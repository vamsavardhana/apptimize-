# -*- coding: utf-8 -*-
from selenium.webdriver.firefox.webdriver import WebDriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
import time

success = True
wd = WebDriver()
wd.implicitly_wait(60)

def is_alert_present(wd):
    try:
        wd.switch_to_alert().text
        return True
    except:
        return False

try:
    wd.get("https://apptimize.com/30-day-trial")
    wd.find_element_by_id("jobtitle").click()
    wd.find_element_by_id("jobtitle").send_keys("\\undefined")
    wd.find_element_by_id("password").click()
    wd.find_element_by_id("password").send_keys("\\undefined")
    wd.find_element_by_id("fname").click()
    wd.find_element_by_id("fname").clear()
    wd.find_element_by_id("fname").send_keys("Vamsavardhana")
    wd.find_element_by_id("lname").click()
    wd.find_element_by_id("lname").clear()
    wd.find_element_by_id("lname").send_keys("Vijay")
    wd.find_element_by_id("email").click()
    wd.find_element_by_id("email").clear()
    wd.find_element_by_id("email").send_keys("vamvad2@gmail.com")
    wd.find_element_by_id("company").click()
    wd.find_element_by_id("company").clear()
    wd.find_element_by_id("company").send_keys("Apptimize Candidate")
    wd.find_element_by_id("phone").click()
    wd.find_element_by_id("phone").clear()
    wd.find_element_by_id("phone").send_keys("7194935219")
    wd.find_element_by_id("jobtitle").click()
    wd.find_element_by_id("jobtitle").clear()
    wd.find_element_by_id("jobtitle").send_keys("vamvad2@gmail.com")
    wd.find_element_by_id("password").click()
    wd.find_element_by_id("password").clear()
    wd.find_element_by_id("password").send_keys("vamsaV1234@")
    if not wd.find_element_by_xpath("//div[@class='form_main']/div[2]/div[6]/div[2]/input[2]").is_selected():
        wd.find_element_by_xpath("//div[@class='form_main']/div[2]/div[6]/div[2]/input[2]").click()
    if not wd.find_element_by_id("eula").is_selected():
        wd.find_element_by_id("eula").click()
    wd.find_element_by_id("submit").click()
    wd.find_element_by_id("zet-login-email").click()
    wd.find_element_by_id("zet-login-email").send_keys("\\undefined")
    wd.find_element_by_id("zet-login-password").click()
    wd.find_element_by_id("zet-login-password").send_keys("\\undefined")
finally:
    wd.quit()
    if not success:
        raise Exception("Test failed.")
