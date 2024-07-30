using System;

namespace PSY
{
    internal class Class12
    {
        static void Main()
        {
            string S = Console.ReadLine();
            string T = Console.ReadLine();

            while (T.Length > S.Length)
                T = (T[T.Length - 1] == 'A') ? T.Remove(T.Length - 1) : new string(T.Remove(T.Length - 1).Reverse().ToArray());

            Console.WriteLine(S == T ? 1 : 0);
        }
    }
}
