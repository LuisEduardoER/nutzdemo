3��Aop����,������������Nut.Aop
By Wendal

������jar,���µ�nutz,Ϊ�������־,�㻹��Ҫlog4j,������lab���ҵ�.

1. ����A �ı䷵��ֵ
Ioc ioc = new NutIoc(new JsonLoader("ioc.js"));
Integer integer = ioc.get(GetMinValue.class, "getmax").getMin();
System.out.printf("�õ���ֵ: %s \n",integer);

�������,ͨ��������,����ԭ�еķ���ֵ,���з���һ��ֵ.

2. ����B ��Ϊ������������
TwoMethod tm = ioc.get(TwoMethod.class, "tm");
DiffMethodInterceptor diffm = ioc.get(DiffMethodInterceptor.class, "diffm");
tm.methodA();//����һ�·���A,����ʲô��ִ����
//�����ҶԷ���A����,�Ҿ��÷���B���Щ,so..
diffm.setCanOrgl(false);//����������,�Ҳ�����÷���A��
tm.methodA();

ͨ��������������״̬,��������ı������һ������,���������ʱ����Ŷ

3. ����C ��һ���򻯵�Ȩ��������
oc.get(CanPass.class, "canpass").getIt(); //�������õö���Ǯ
System.out.println("����ǿ��,�������õ�����Ǯ: "+ ioc.get(SecurityMethod.class, "securityMethod").giveMeMoney());
System.out.println(ioc.get(null, "securityMethod") instanceof SecurityMethod);

ͨ����ȡ�����ߵ���Ϣ,�ж��Ƿ��������ԭ����



4. ��סŶ,���������ҪIoc֧�ֵ�. O(��_��)O����~
Any question? free to ask !