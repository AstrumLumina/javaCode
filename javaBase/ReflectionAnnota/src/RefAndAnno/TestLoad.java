package RefAndAnno;

public class TestLoad {
    public static void main(String[] args)  {
        {;
            //����ع���*******************************
            //����غ�Ỻ��һ��ʱ��,Ҳ���ܱ�����
    /*
    1.����:��class�ļ����ص��ڴ���,������Щ��̬����ת�������������ݽṹ,Ȼ������һ��java.lang.Class����
    2.����:��Java�����ƴ���ϲ�������״̬
      a.��֤:ȷ���������Ϣ���Ϲ淶,û�а�ȫ����
      b.׼��:�ڷ�����Ϊ��ľ�̬���������ڴ沢Ĭ�ϳ�ʼ��
      c.����:�������ñ�Ϊ��ַ����
    3.��ʼ��
    ִ���๹����(��������ĳ�ʼ�����ϲ������)
    ������δ����,���ȼ��ظ���
    ��֤�̰߳�ȫ
     */

            //*********************************************8
            //��ʱ������ĳ�ʼ��
    /*
     �����������mian������
     new����ʱ,������ľ�̬�����ͳ�Ա(����final����)
     �������ʱ
     �����ʼ��ʱ��ʼ������
     */
            //����ʼ��
    /*
    1.������ø���ľ�̬����
    2.���鶨���������
    3.����������(�����ӽ׶ξ�����ĳ���������)
     */
//��ļ�����*************************
    /*
    1.�����������(�޷�ֱ�ӻ�ȡ)(rtjar)  ����,c/c++��д ������Ŀ�
    2.���ż�����(ext)/APP������
    3.ϵͳ������.java.class.path
    4.�Զ��������

     */
        }
        //��ȡϵͳ�������
        ClassLoader systemload=ClassLoader.getSystemClassLoader();
        System.out.println(systemload);
        //��ȡϵͳ�������ĸ���--------��չ���������
        ClassLoader parent=systemload.getParent();
        System.out.println(parent);
        //��ȡ��չ��������ĸ���------������/�� ������ ---���ɻ��,����null
        ClassLoader pparent=parent.getParent();
        System.out.println(pparent);

//˫��ί�ɻ��� ��������:���Լ�д�˸���ϵͳһ���İ�,��ʹ��ϵͳ�İ�
        //�鿴��ǰ��ļ�����
        ClassLoader loader= null;
        try {
            loader = Class.forName("RefAndAnno.TestLoad").getClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loader);
        //�鿴������ļ�����
        try {
            loader = Class.forName("java.lang.Object").getClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loader);

        //��ȡ��ϵͳ����������Լ��ص�·��
        System.out.println(System.getProperty("java.class.path"));
    }
}
