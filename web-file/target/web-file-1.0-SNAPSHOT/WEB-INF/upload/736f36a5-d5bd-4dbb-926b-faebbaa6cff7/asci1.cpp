#include<iostream>
#include<ctime> 
int main(void){
	int a=int('`');
	std::cout<<a<<std::endl;
	struct tm starttime;
	

	starttime.tm_mday = 0;
	

	starttime.tm_min = 0;
	starttime.tm_hour = 0;
	//starttime.tm_isdst = 0;
	starttime.tm_sec = 0;
	
	starttime.tm_yday = 0;
	starttime.tm_year = 1;
	starttime.tm_min = 0;
	starttime.tm_hour = 0;
	starttime.tm_isdst = 0;
//	starttime.tm_mon = 0;
	starttime.tm_sec = 0;
	//starttime.tm_wday = 0; //不确定,其他信息确定后这个会自动的确定
	//starttime.tm_mday = 0;
	int oneyear=mktime(&starttime);
	std::cout<<oneyear;
	return 0;
}
