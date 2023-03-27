/**
 *  to test whether this js is working --> alert("Hello...");
 */
const links = document.querySelectorAll(".smenu");
const themeToggler = document.querySelector(".theme-toggler");

links.forEach(btn => btn.addEventListener("click",(e)=>{
    e.preventDefault();
    document.querySelector(".smenu.active").classList.remove("active");
    btn.classList.add("active");
}));

// change theme
themeToggler.addEventListener('click', ()=>{
    document.body.classList.toggle('dark-theme-variables');

    themeToggler.querySelector('span:nth-child(1)').classList.toggle('active');
    themeToggler.querySelector('span:nth-child(2)').classList.toggle('active');
});

function customerMenuClick() {
	zAu.send(new zk.Event(zk.Widget.$(this), 'onClickCustomerMenu', 'Customer...'));
}

function dashboardMenuClick() {
	zAu.send(new zk.Event(zk.Widget.$(this), 'onClickDashboardMenu', 'Dashboard...'));
}

function ordersMenuClick() {
	zAu.send(new zk.Event(zk.Widget.$(this), 'onClickOrdersMenu', 'Orders...'));
}

function userProfileClick() {
	zAu.send(new zk.Event(zk.Widget.$(this), 'onClickUserProfile', 'UserProfile...'));
}