package leetcodeSimp;

public class Merge {
    /*
    ���������� �ǵݼ�˳�� ���е���������?nums1 �� nums2�������������� m �� n ���ֱ��ʾ nums1 �� nums2 �е�Ԫ����Ŀ��

���� �ϲ� nums2 �� nums1 �У�ʹ�ϲ��������ͬ���� �ǵݼ�˳�� ���С�

ע�⣺���գ��ϲ������鲻Ӧ�ɺ������أ����Ǵ洢������ nums1 �С�Ϊ��Ӧ�����������nums1 �ĳ�ʼ����Ϊ m + n������ǰ m ��Ԫ�ر�ʾӦ�ϲ���Ԫ�أ��� n ��Ԫ��Ϊ 0 ��Ӧ���ԡ�nums2 �ĳ���Ϊ n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int located = m + n - 1;
        --m;
        --n;
        while (n >= 0) {
            if (m == -1 || nums2[n] > nums1[m]) {
                nums1[located] = nums2[n];
                --n;
            } else {
                nums1[located] = nums1[m];
                --m;
            }
            --located;
        }
    }
}
